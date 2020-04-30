package com.liang.service;

import com.liang.api.OrderService;
import com.liang.domain.Order;
import com.liang.mapper.OrderMapper;
import com.liang.utils.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;

/**
 * @author Liangxp
 * @date 2020/4/30 9:22
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Value("${server.port}")
    private Integer port;

    @Resource
    private OrderMapper orderMapper;

    @Override
    public void add(Order order) {
        log.info(">>>>>>>>>>>下单开始,端口：{}", port);
        order.setId(IdUtil.getId());
        orderMapper.create(order);
        log.info(">>>>>>>>>>>下单结束");
    }
}
