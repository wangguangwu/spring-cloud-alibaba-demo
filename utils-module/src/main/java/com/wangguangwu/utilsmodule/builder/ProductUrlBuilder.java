package com.wangguangwu.utilsmodule.builder;

import com.wangguangwu.utilsmodule.constant.ServiceConstants;

/**
 * @author wangguangwu
 */
public class ProductUrlBuilder {

    private ProductUrlBuilder() {
    }

    public static String query(Long productId) {
        return UrlBuilder.url(ServiceConstants.PRODUCT_SERVER, "/product/get/" + productId);
    }

    public static String updateCount(Long productId, Integer count) {
        return UrlBuilder.url(ServiceConstants.PRODUCT_SERVER, "/product/updateCount/" + productId + "/" + count);
    }
}
