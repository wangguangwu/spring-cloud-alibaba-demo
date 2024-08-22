package com.wangguangwu.beanmodule.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单项表
 * </p>
 *
 * @author wangguangwu
 * @since 2024-08-22
 */
@Getter
@Setter
public class OrderItemInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 商品id
     */
    private Long proId;

    /**
     * 商品名称
     */
    private String proName;

    /**
     * 商品价格（单价）
     */
    private BigDecimal proPrice;

    /**
     * 购买数量
     */
    private Integer number;

    /**
     * 删除标志位。0：未删除；1：已删除
     */
    private Boolean isDeleted;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtUpdated;
}
