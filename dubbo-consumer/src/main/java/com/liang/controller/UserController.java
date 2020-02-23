package com.liang.controller;

import com.liang.api.UserService;
import com.liang.entity.User;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liangxp
 * @date 2020/2/21 19:15
 */
@RestController
public class UserController {

    @Reference(version = "1.0.0")
    private UserService userService;

    @GetMapping(value = "/hello/{name}")
    public String hello(@PathVariable String name) {
        return userService.hello(name);
    }

    @GetMapping(value = "/getById/{id}")
    public User getById(@PathVariable Long id){
        return userService.getById(id);
    }
}
