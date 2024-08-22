package com.wangguangwu.ordermodule.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wangguangwu.beanmodule.bean.*;
import com.wangguangwu.ordermodule.entity.OrderInfoDO;
import com.wangguangwu.ordermodule.entity.OrderItemInfoDO;
import com.wangguangwu.ordermodule.mapper.OrderInfoMapper;
import com.wangguangwu.ordermodule.mapper.OrderItemInfoMapper;
import com.wangguangwu.ordermodule.service.OrderService;
import com.wangguangwu.utilsmodule.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderInfoMapper orderInfoMapper;
    @Resource
    private OrderItemInfoMapper orderItemInfoMapper;
    @Resource
    private RestTemplate restTemplate;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long saveOrder(OrderParams orderParams) {
        String userUrl = "http://localhost:9020/user/get/" + orderParams.getUserId();
        User user = restTemplate.getForObject(userUrl, User.class);
        if (user == null) {
            throw new ServiceException("未获取到用户信息: " + JSONObject.toJSONString(orderParams));
        }

        String productUrl = "http://localhost:9010/product/get/" + orderParams.getProductId();
        Product product = restTemplate.getForObject(productUrl, Product.class);
        if (product == null) {
            throw new ServiceException("未获取到商品信息: " + JSONObject.toJSONString(orderParams));
        }
        if (product.getProStock() < orderParams.getCount()) {
            throw new ServiceException("商品库存不足: " + JSONObject.toJSONString(orderParams));
        }

        OrderInfoDO orderInfo = new OrderInfoDO();
        orderInfo.setAddress(user.getAddress());
        orderInfo.setPhone(user.getPhone());
        orderInfo.setUserId(user.getId());
        orderInfo.setUserName(user.getUsername());
        orderInfo.setTotalPrice(product.getProPrice().multiply(BigDecimal.valueOf(orderParams.getCount())));
        orderInfoMapper.insert(orderInfo);

        // 获取订单id
        Long oId = orderInfo.getId();

        OrderItemInfoDO orderItemInfo = new OrderItemInfoDO();
        orderItemInfo.setNumber(orderParams.getCount());
        orderItemInfo.setOrderId(oId);
        orderItemInfo.setProId(product.getId());
        orderItemInfo.setProName(product.getProName());
        orderItemInfo.setProPrice(product.getProPrice());
        orderItemInfoMapper.insert(orderItemInfo);
        return oId;
    }

    @Override
    public OrderDetails getOrderDetails(Long oid) {
        // 查询订单信息
        OrderInfo orderInfo = getOrderInfo(oid);
        // 查询订单项信息
        List<OrderItemInfo> orderItemInfoList = getOrderItemInfoList(oid);

        return OrderDetails.builder()
                .orderInfo(orderInfo).orderItemInfoList(orderItemInfoList)
                .build();
    }

    private OrderInfo getOrderInfo(Long oid) {
        OrderInfoDO orderInfoDO = orderInfoMapper.selectById(oid);
        if (orderInfoDO == null) {
            throw new ServiceException("订单不存在");
        }
        OrderInfo orderInfo = new OrderInfo();
        BeanUtils.copyProperties(orderInfoDO, orderInfo);
        return orderInfo;
    }

    private List<OrderItemInfo> getOrderItemInfoList(Long oid) {
        LambdaQueryWrapper<OrderItemInfoDO> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(OrderItemInfoDO::getOrderId, oid);
        List<OrderItemInfoDO> orderItemInfoDOList = orderItemInfoMapper.selectList(lambdaQueryWrapper);

        return orderItemInfoDOList.stream()
                .map(orderItemInfoDO -> {
                    OrderItemInfo orderItemInfo = new OrderItemInfo();
                    BeanUtils.copyProperties(orderItemInfoDO, orderItemInfo);
                    return orderItemInfo;
                }).collect(Collectors.toList());
    }
}
