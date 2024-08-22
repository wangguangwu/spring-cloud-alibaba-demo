package com.wangguangwu.productmodule.service;

import com.wangguangwu.beanmodule.bean.Product;

/**
 * @author wangguangwu
 */
public interface ProductService {

    /**
     * 根据商品id获取商品信息
     */
    Product getProductById(Long pid);

    /**
     * 扣减商品库存
     */
    int updateProductStockById(Integer count, Long id);

}
