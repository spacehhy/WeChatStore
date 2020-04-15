package com.hhy.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hhy.dataobject.OrderDetail;
import com.hhy.dataobject.OrderMaster;
import com.hhy.enums.OrderStatusEnum;
import com.hhy.enums.PayStatusEnum;
import com.hhy.utils.EnumUtil;
import com.hhy.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单DTO data transfer object 数据传输对象
 */
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonInclude(JsonInclude.Include.NON_NULL)
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

    /** 订单状态,默认0为新下单. */
    private Integer orderStatus;

    /** 支付状态,默认0为未支付. */
    private Integer payStatus;

    /** 创建时间. */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /** 更新时间. */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    /*
    将数据返回给前台,
    如果非必须返回该字段,可以使用@JsonInclude(JsonInclude.Include.NON_NULL) 或者 jackson 全局null配置
    如果必须返回该字段,但不可为null,这种情况应该赋初始值 引用类型赋值空对象 String赋值 "" int赋值 0 等
    private List<OrderDetail> orderDetailList = new ArrayList<>();
    */
    private List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }
}
