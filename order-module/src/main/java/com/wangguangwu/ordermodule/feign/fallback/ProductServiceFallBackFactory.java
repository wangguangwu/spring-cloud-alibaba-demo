package com.wangguangwu.ordermodule.feign.fallback;

import com.wangguangwu.beanmodule.bean.Product;
import com.wangguangwu.ordermodule.feign.ProductService;
import com.wangguangwu.utilsmodule.response.Response;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 服务容错
 *
 * @author wangguangwu
 */
@Component
public class ProductServiceFallBackFactory implements FallbackFactory<ProductService> {

    @Override
    public ProductService create(Throwable cause) {
        return new ProductService() {
            @Override
            public Response<Product> getProduct(Long pid) {
                return Response.error("查询失败，触发容错机制");
            }

            @Override
            public Response<Integer> updateCount(Long pid, Integer count) {
                return Response.error("查询失败，触发容错机制");
            }
        };
    }
}
