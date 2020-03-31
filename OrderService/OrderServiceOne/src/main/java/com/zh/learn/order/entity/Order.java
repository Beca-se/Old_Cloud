package com.zh.learn.order.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author ZhouHu
 * @Class Name Order
 * @Desc Order表
 * @create: 2020-03-19 11:24
 **/
@Data
public class Order {
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 金额
     */
    private BigDecimal money;

    /**
     * 订单状态：0：创建中；1：已完结
     */
    private Integer status;


}