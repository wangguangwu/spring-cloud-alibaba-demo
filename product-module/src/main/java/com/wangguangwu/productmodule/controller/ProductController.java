package com.wangguangwu.productmodule.controller;

import com.alibaba.fastjson2.JSONObject;
import com.wangguangwu.beanmodule.bean.Product;
import com.wangguangwu.productmodule.service.ProductService;
import com.wangguangwu.utilsmodule.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author wangguangwu
 */
@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping(value = "/get/{pid}")
    public Response<Product> getProduct(@PathVariable("pid") Long pid) {
        Product product = productService.getProductById(pid);
        log.info("获取到的商品信息为：{}", JSONObject.toJSONString(product));
        return Response.success(product);
    }

    @PostMapping(value = "/updateCount/{pid}/{count}")
    public Response<Integer> updateCount(@PathVariable("pid") Long pid, @PathVariable("count") Integer count) {
        log.info("更新商品库存传递的参数为: 商品id:{}, 购买数量:{} ", pid, count);
        int updateCount = productService.updateProductStockById(count, pid);
        return Response.success(updateCount);
    }
}
