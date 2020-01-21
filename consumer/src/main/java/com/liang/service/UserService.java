package com.liang.service;

import com.liang.service.fallback.UserServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Liangxp
 * @date 2020/1/20 16:45
 */
@FeignClient(name = "service-provider", fallback = UserServiceImpl.class)
public interface UserService {

    @GetMapping("/user/hello/{name}")
    String hello(@PathVariable String name);
}
