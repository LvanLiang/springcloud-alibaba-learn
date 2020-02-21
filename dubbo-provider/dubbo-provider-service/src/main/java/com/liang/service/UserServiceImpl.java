package com.liang.service;

import com.liang.api.UserService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author Liangxp
 * @date 2020/2/21 17:10
 */
@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {
    @Override
    public String hello(String name) {
        return "hello……".concat(name);
    }
}
