package com.liang.mapper;

import com.liang.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Liangxp
 * @date 2020/4/30 9:25
 */
@Mapper
public interface OrderMapper {
    /**
     * 新建订单
     * @param order
     */
    void create(Order order);

    /**
     * 修改订单状态
     * @param userId 用户id
     * @param status 订单状态
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
