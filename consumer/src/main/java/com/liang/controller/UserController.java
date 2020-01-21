package com.liang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Liangxp
 * @date 2020/1/20 16:14
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private final RestTemplate restTemplate;

    public UserController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/hello/{name}")
    public String hello(@PathVariable String name) {
        // 使用服务名请求服务提供者
        return restTemplate.getForObject("http://service-provider/user/hello/" + name, String.class);
    }

}
