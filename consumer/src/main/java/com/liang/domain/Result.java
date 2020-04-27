package com.liang.domain;

import lombok.Builder;
import lombok.Data;

/**
 * @author Liangxp
 * @date 2020/4/27 11:40
 */
@Data
@Builder
public class Result <T> {
    private Integer code;
    private String message;
    private T data;
}
