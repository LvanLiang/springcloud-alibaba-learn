package com.liang.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Liangxp
 * @date 2020/2/23 16:07
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -8150905978335885892L;
    private Long id;
    private String userName;
    private Integer port;
}
