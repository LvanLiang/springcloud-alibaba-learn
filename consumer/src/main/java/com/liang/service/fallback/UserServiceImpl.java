package com.liang.service.fallback;

import com.liang.service.UserService;
import org.springframework.stereotype.Component;

/**
 * @author Liangxp
 * @date 2020/1/21 15:24
 */
@Component
public class UserServiceImpl implements UserService {
    @Override
    public String hello(String name) {
        return "服务异常了！！！";
    }
}
