package com.wangguangwu.ordermodule.service;

import com.wangguangwu.beanmodule.bean.OrderDetails;
import com.wangguangwu.beanmodule.bean.OrderParams;

/**
 * @author wangguangwu
 */
public interface OrderService {

    /**
     * 保存订单
     */
    void saveOrder(OrderParams orderParams);

    OrderDetails getOrderDetails(Long oid);

}
