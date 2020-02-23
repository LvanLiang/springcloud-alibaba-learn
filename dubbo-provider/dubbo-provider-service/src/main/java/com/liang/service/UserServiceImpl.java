package com.liang.service;

import com.liang.api.UserService;
import com.liang.entity.User;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author Liangxp
 * @date 2020/2/21 17:10
 */
@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {
    @Value("${dubbo.protocol.port}")
    private Integer port;

    @Override
    public String hello(String name) {
        return "hello……".concat(name);
    }

    @Override
    public User getById(Long id) {
        User user = new User();
        user.setId(id);
        user.setUserName("lian");
        user.setPort(port);
        return user;
    }
}
