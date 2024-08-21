package com.wangguangwu.productmodule.mapper;

import com.wangguangwu.productmodule.entity.ProductInfoDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author wangguangwu
 * @since 2024-08-21
 */
public interface ProductInfoMapper extends BaseMapper<ProductInfoDO> {

    /**
     * 扣减商品库存
     */
    int updateProductStockById(@Param("count") Integer count, @Param("id") Long id);

}
