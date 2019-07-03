package com.mypack.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {

    @Id
    private String detailId;
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 商品id
     */
    private String productId;
    /**
     * 商品名字
     */
    private String productName;
    /**
     * 单价
     */
    private BigDecimal productPrice;
    /**
     * 商品数量
     */
    private Integer productQuantity;
    /**
     * 商品图片
     */
    private String productIcon;



}
