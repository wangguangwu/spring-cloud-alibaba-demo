package com.wangguangwu.ordermodule.service.impl;

import com.wangguangwu.beanmodule.bean.OrderDetails;
import com.wangguangwu.beanmodule.bean.OrderParams;
import com.wangguangwu.ordermodule.mapper.OrderInfoMapper;
import com.wangguangwu.ordermodule.mapper.OrderItemInfoMapper;
import com.wangguangwu.ordermodule.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

    @Override
    public void saveOrder(OrderParams orderParams) {

    }

    @Override
    public OrderDetails getOrderDetails(Long oid) {
        return null;
    }
}
