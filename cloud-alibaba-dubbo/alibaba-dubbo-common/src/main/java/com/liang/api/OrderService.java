package com.liang.api;

import com.liang.domain.Order;

/**
 * @author Liangxp
 * @date 2020/4/29 16:42
 */
public interface OrderService {
    /**
     * 新增订单
     * @param order 订单信息
     */
    void add(Order order);
}
