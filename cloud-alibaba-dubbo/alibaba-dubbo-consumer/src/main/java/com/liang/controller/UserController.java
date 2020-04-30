package com.liang.controller;

import com.liang.api.OrderService;
import com.liang.api.StorageService;
import com.liang.common.Result;
import com.liang.domain.Order;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liangxp
 * @date 2020/4/29 17:18
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Reference
    private OrderService orderService;

    @Reference
    private StorageService storageService;

    @PostMapping("/buy")
    public Result buy(Order order) {
        orderService.add(order);
        storageService.decrease(order.getProductId(),order.getCount());
        return new Result<>(200, "下单成功");
    }
}
