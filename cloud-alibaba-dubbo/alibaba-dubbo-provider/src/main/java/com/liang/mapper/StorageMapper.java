package com.liang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Liangxp
 * @date 2020/4/29 17:05
 */
@Mapper
public interface StorageMapper {
    /**
     * 扣减库存
     * @param productId 产品id
     * @param count 扣减数量
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}