package com.liang.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Liangxp
 * @date 2020/4/29 16:43
 */
@Data
public class Storage implements Serializable {
    private static final long serialVersionUID = 7527650408049934891L;

    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}