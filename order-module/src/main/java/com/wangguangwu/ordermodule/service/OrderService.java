package com.wangguangwu.ordermodule.service;

import com.wangguangwu.beanmodule.bean.OrderDetails;
import com.wangguangwu.beanmodule.bean.OrderParams;

/**
 * @author wangguangwu
 */
public interface OrderService {

    /**
     * 保存订单
     *
     * @return 订单id
     */
    Long saveOrder(OrderParams orderParams);

    /**
     * 查询订单信息
     *
     * @param oid 订单id
     */
    OrderDetails getOrderDetails(Long oid);

}
