package com.mypack.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
    /**
     * 商品id
     */
    private String productId;
    /**
     * 数量
     */
    private Integer productQuantity;
}
