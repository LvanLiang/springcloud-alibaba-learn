package com.liang.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Liangxp
 * @date 2020/1/20 16:45
 */
@FeignClient(name = "service-provider")
public interface UserService {

    @GetMapping("/user/hello/{name}")
    String hello(@PathVariable String name);
}
