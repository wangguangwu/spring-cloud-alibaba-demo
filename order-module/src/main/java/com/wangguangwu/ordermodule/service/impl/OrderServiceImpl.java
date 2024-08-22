package com.wangguangwu.ordermodule.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wangguangwu.beanmodule.bean.*;
import com.wangguangwu.ordermodule.entity.OrderInfoDO;
import com.wangguangwu.ordermodule.entity.OrderItemInfoDO;
import com.wangguangwu.ordermodule.feign.ProductService;
import com.wangguangwu.ordermodule.feign.UserService;
import com.wangguangwu.ordermodule.mapper.OrderInfoMapper;
import com.wangguangwu.ordermodule.mapper.OrderItemInfoMapper;
import com.wangguangwu.ordermodule.service.OrderService;
import com.wangguangwu.utilsmodule.exception.ServiceException;
import com.wangguangwu.utilsmodule.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private ProductService productService;
    @Resource
    private UserService userService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long saveOrder(OrderParams orderParams) {
        // 获取用户信息
        User user = getUser(orderParams);
        // 获取商品信息
        Product product = getProduct(orderParams);
        // 保存订单信息
        OrderInfoDO orderInfo = getOrderInfoDO(orderParams, user, product);
        // 获取订单id
        Long oId = orderInfo.getId();
        // 保存订单项逆袭
        insertOrderItemInfo(orderParams, oId, product);
        // 更新库存
        updateProductCount(orderParams);
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

    private void insertOrderItemInfo(OrderParams orderParams, Long oId, Product product) {
        OrderItemInfoDO orderItemInfo = new OrderItemInfoDO();
        orderItemInfo.setNumber(orderParams.getCount());
        orderItemInfo.setOrderId(oId);
        orderItemInfo.setProId(product.getId());
        orderItemInfo.setProName(product.getProName());
        orderItemInfo.setProPrice(product.getProPrice());
        orderItemInfoMapper.insert(orderItemInfo);
    }

    private OrderInfoDO getOrderInfoDO(OrderParams orderParams, User user, Product product) {
        OrderInfoDO orderInfo = new OrderInfoDO();
        orderInfo.setAddress(user.getAddress());
        orderInfo.setPhone(user.getPhone());
        orderInfo.setUserId(user.getId());
        orderInfo.setUserName(user.getUsername());
        orderInfo.setTotalPrice(product.getProPrice().multiply(BigDecimal.valueOf(orderParams.getCount())));
        orderInfoMapper.insert(orderInfo);
        return orderInfo;
    }

    private Product getProduct(OrderParams orderParams) {
        Response<Product> response = productService.getProduct(orderParams.getProductId());
        if (response == null || response.isFail() || response.getData() == null) {
            throw new ServiceException("未获取到商品信息: " + JSONObject.toJSONString(orderParams));
        }
        Product product = response.getData();
        if (product.getProStock() < orderParams.getCount()) {
            throw new ServiceException("商品库存不足: " + JSONObject.toJSONString(orderParams));
        }
        return product;
    }

    private User getUser(OrderParams orderParams) {
        Response<User> response = userService.getUser(orderParams.getUserId());
        if (response == null || response.isFail() || response.getData() == null) {
            throw new ServiceException("未获取到用户信息: " + JSONObject.toJSONString(response));
        }
        return response.getData();
    }

    private void updateProductCount(OrderParams orderParams) {
        Response<Integer> response = productService.updateCount(orderParams.getProductId(), orderParams.getCount());
        if (response == null || response.isFail() || response.getData() == null) {
            throw new ServiceException("库存扣减失败");
        }
    }
}
