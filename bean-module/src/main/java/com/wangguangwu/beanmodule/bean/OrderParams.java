package com.wangguangwu.beanmodule.bean;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;


/**
 * @author wangguangwu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderParams {

    /**
     * 商品id
     */
    @NotNull(message = "商品id不能为空")
    private Long productId;

    /**
     * 用户id
     */
    @NotNull(message = "用户id不能为空")
    private Long userId;

    /**
     * 购买的商品数量
     */
    @NotNull(message = "商品数量不能为空")
    @Min(value = 1, message = "商品数量至少为1")
    private Integer count;

}
