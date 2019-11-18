package com.hhy.enums;

import lombok.Getter;

/**
 * 商品状态
 */
@Getter
public enum  OrderStatusEnum {
    NEW(0,"新订单"),
    FINISH(1,"完结"),
    CANCEL(2,"已取消"),
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
