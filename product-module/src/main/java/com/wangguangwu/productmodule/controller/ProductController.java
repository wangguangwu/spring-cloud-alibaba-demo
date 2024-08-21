package com.wangguangwu.productmodule.controller;

import com.alibaba.fastjson2.JSONObject;
import com.wangguangwu.productmodule.entity.ProductInfoDO;
import com.wangguangwu.productmodule.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ProductInfoDO getProduct(@PathVariable("pid") Long pid) {
        ProductInfoDO product = productService.getProductById(pid);
        log.info("获取到的商品信息为：{}", JSONObject.toJSONString(product));
        return product;
    }

}
