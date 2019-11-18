package com.hhy.dto;

import com.hhy.dataobject.OrderDetail;
import com.hhy.dataobject.OrderMaster;
import com.hhy.enums.OrderStatusEnum;
import com.hhy.enums.PayStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单DTO data transfer object 数据传输对象
 */
@Data
public class OrderDTO {

    /** 订单ID. */
    private String orderId;

    /** 买家名称. */
    private String buyerName;

    /** 买家手机号码. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 买家微信OpenId. */
    private String buyerOpenid;

    /** 订单金额. */
    private BigDecimal orderAmount;

    /** 订单状态,默认为新下单. */
    private Integer orderStatus;

    /** 支付状态,默认为0未支付. */
    private Integer payStatus;

    private List<OrderDetail> orderDetailList;
}
