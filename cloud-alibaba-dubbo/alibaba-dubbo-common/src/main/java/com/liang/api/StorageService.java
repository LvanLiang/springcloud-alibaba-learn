package com.liang.api;

/**
 * @author Liangxp
 * @date 2020/4/29 16:53
 */
public interface StorageService {
    /**
     * 扣减库存
     * @param productId 产品id
     * @param count 数量
     */
    void decrease(Long productId, Integer count);
}
