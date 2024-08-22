package com.wangguangwu.ordermodule.feign;

import com.wangguangwu.beanmodule.bean.Product;
import com.wangguangwu.utilsmodule.constant.ServiceConstants;
import com.wangguangwu.utilsmodule.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author wangguangwu
 */
@FeignClient(value = ServiceConstants.PRODUCT_SERVER)
public interface ProductService {

    /**
     * 获取商品信息
     *
     * @param pid 商品id
     * @return 商品信息
     */
    @GetMapping(value = "/product/get/{pid}")
    Response<Product> getProduct(@PathVariable("pid") Long pid);

    /**
     * 更新库存数量
     *
     * @param pid   商品id
     * @param count 消耗库存
     * @return 剩余库存
     */
    @PostMapping(value = "/product/updateCount/{pid}/{count}")
    Response<Integer> updateCount(@PathVariable("pid") Long pid, @PathVariable("count") Integer count);

}
