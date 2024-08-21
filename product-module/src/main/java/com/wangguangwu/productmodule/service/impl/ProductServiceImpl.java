package com.wangguangwu.productmodule.service.impl;

import com.wangguangwu.productmodule.entity.ProductInfoDO;
import com.wangguangwu.productmodule.mapper.ProductInfoMapper;
import com.wangguangwu.productmodule.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductInfoMapper productInfoMapper;

    @Override
    public ProductInfoDO getProductById(Long pid) {
        return productInfoMapper.selectById(pid);
    }

    @Override
    public int updateProductStockById(Integer count, Long id) {
        return productInfoMapper.updateProductStockById(count, id);
    }
}
