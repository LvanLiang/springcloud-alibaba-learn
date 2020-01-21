package com.liang.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liangxp
 * @date 2020/1/20 14:57
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return String.format("你好呀,%s====%s", name, port);
    }
}
