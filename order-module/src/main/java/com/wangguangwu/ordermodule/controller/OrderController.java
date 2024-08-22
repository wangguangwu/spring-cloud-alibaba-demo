package com.wangguangwu.ordermodule.controller;

import com.wangguangwu.beanmodule.bean.OrderDetails;
import com.wangguangwu.ordermodule.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangguangwu
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/get/{oid}")
    public OrderDetails getOrderDetails(@PathVariable("oid") Long oid) {
        OrderDetails orderDetails = orderService.getOrderDetails(oid);
        log.info("根据订单id[{}]获取订单信息: {}", oid, orderDetails);
        return orderDetails;
    }
}
