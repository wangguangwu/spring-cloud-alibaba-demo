package com.wangguangwu.productmodule.service;

import com.wangguangwu.productmodule.entity.ProductInfoDO;

/**
 * @author wangguangwu
 */
public interface ProductService {

    /**
     * 根据商品id获取商品信息
     */
    ProductInfoDO getProductById(Long pid);

    /**
     * 扣减商品库存
     */
    int updateProductStockById(Integer count, Long id);

}
