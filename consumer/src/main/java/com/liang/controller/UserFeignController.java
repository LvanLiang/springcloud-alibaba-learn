package com.liang.controller;

import com.liang.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 使用feign实现服务调用和负载均衡
 * @author Liangxp
 * @date 2020/1/20 16:45
 */
@RestController
@RequestMapping("/userFeign")
public class UserFeignController {
    private UserService userService;

    public UserFeignController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/hello/{name}")
    public String hello(@PathVariable String name) {
       return userService.hello(name);
    }
}
