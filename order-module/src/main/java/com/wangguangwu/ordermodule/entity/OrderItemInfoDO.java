package com.wangguangwu.ordermodule.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

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
@TableName("t_order_item_info")
public class OrderItemInfoDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单id
     */
    @TableField("order_id")
    private Long orderId;

    /**
     * 商品id
     */
    @TableField("pro_id")
    private Long proId;

    /**
     * 商品名称
     */
    @TableField("pro_name")
    private String proName;

    /**
     * 商品价格（单价）
     */
    @TableField("pro_price")
    private BigDecimal proPrice;

    /**
     * 购买数量
     */
    @TableField("number")
    private Integer number;

    /**
     * 删除标志位。0：未删除；1：已删除
     */
    @TableField("is_deleted")
    @TableLogic
    private Boolean isDeleted;

    /**
     * 创建时间
     */
    @TableField("gmt_create")
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    @TableField("gmt_updated")
    private LocalDateTime gmtUpdated;
}
