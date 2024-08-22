package com.wangguangwu.productmodule.service.impl;

import com.wangguangwu.beanmodule.bean.Product;
import com.wangguangwu.productmodule.mapper.ProductInfoMapper;
import com.wangguangwu.productmodule.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductInfoMapper productInfoMapper;

    @Override
    public Product getProductById(Long pid) {
        return Optional.ofNullable(productInfoMapper.selectById(pid))
                .map(productInfoDO -> {
                    Product product = new Product();
                    BeanUtils.copyProperties(productInfoDO, product);
                    return product;
                })
                .orElse(null);
    }

    @Override
    public int updateProductStockById(Integer count, Long id) {
        return productInfoMapper.updateProductStockById(count, id);
    }
}
