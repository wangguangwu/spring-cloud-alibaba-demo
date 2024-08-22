package com.wangguangwu.beanmodule.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Long productId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 购买的商品数量
     */
    private Integer count;

}
