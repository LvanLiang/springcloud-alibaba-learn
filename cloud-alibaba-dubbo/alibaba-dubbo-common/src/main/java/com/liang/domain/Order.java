package com.liang.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Liangxp
 * @date 2020/4/29 16:41
 */
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = 3365082841645649920L;

    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    /**
     * 订单状态：0：创建中；1：已完结
     */
    private Integer status;
}