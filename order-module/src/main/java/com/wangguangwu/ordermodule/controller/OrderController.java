package com.wangguangwu.ordermodule.controller;

import com.alibaba.fastjson2.JSONObject;
import com.wangguangwu.beanmodule.bean.OrderDetails;
import com.wangguangwu.beanmodule.bean.OrderParams;
import com.wangguangwu.ordermodule.service.OrderService;
import com.wangguangwu.utilsmodule.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author wangguangwu
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping(value = "/submitOrder")
    public Response<Long> submitOrder(@RequestBody @Validated OrderParams orderParams) {
        Long userId = orderParams.getUserId();
        log.info("用户[{}]提交订单: {}", userId, JSONObject.toJSONString(orderParams));
        Long oid = orderService.saveOrder(orderParams);
        log.info("用户[{}]生成订单号: {}", userId, oid);
        return Response.success(oid);
    }

    @GetMapping("/get/{oid}")
    public Response<OrderDetails> getOrderDetails(@PathVariable("oid") Long oid) {
        OrderDetails orderDetails = orderService.getOrderDetails(oid);
        log.info("根据订单id[{}]获取订单信息: {}", oid, orderDetails);
        return Response.success(orderDetails);
    }
}
