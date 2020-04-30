package com.liang.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Liangxp
 * @date 2020/3/20 9:53
 */
@Data
public class Result<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    public Result() {
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
