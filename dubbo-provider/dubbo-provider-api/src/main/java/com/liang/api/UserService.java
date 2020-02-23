package com.liang.api;

import com.liang.entity.User;

/**
 * @author Liangxp
 * @date 2020/2/21 15:58
 */
public interface UserService {
    String hello(String name);

    User getById(Long id);
}
