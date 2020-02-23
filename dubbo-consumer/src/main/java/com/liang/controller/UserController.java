package com.liang.controller;

import com.liang.api.UserService;
import com.liang.entity.User;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liangxp
 * @date 2020/2/21 19:15
 */
@RefreshScope
@RestController
public class UserController {

    @Reference(version = "1.0.0")
    private UserService userService;

    @Value("${user.name}")
    private String userName;

    @GetMapping(value = "/hello/{name}")
    public String hello(@PathVariable String name) {
        if (name.length() < 3) {
            return userService.hello(userName);
        }
        return userService.hello(name);
    }

    @GetMapping(value = "/getById/{id}")
    public User getById(@PathVariable Long id){
        return userService.getById(id);
    }
}
