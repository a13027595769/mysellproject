package com.mypack.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultEnum {
    SUCCESS(0,"成功"),
    PARAM_ERROR(1,"参数不正确"),
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"商品库存不正确"),
    ORDER_NOT_EXIST(12,"订单不存在"),
    ORDERDETAIL_NOT_EXIST(13,"订单不存在"),
    ORDER_SATTUS_ERROR(14,"订单状态不正确"),
    ORDER_UPDATE_FAIL(15,"订单更新失败"),
    ORDER_DETAIL_FAIL(16,"订单详情为空"),
    ORDER_PAY_STATUS_ERROR(17,"订单支付状态不正确"),
    CART_EMPTY(18,"购物车不能为空"),
    ORDER_OWNNER_ERROR(19,"该订单不属于当前用户"),
    WECHAT_MP_ERROR(20,"微信公众账号错误"),
    ORDER_CANCEL_SUCCESS(22,"订单取消成功"),
    ORDER_FINISH_SUCCESS(23,"订单完结成功"),
    PRODUCT_STATUS_ERROR(24,"商品状态不正确"),
    PRODUCT_UP_SUCCESS(25,"商品上架成功"),
    PRODUCT_DOWN_SUCCESS(26,"商品下架成功"),
    ;

    private Integer code;

    private String message;
}
