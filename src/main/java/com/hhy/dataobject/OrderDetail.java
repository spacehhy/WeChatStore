package com.hhy.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单详情
 */
@Entity
@Data
@DynamicUpdate
public class OrderDetail {

    /** 订单详情ID. */
    @Id
    //@GeneratedValue(generator = "uuid")
    //@GenericGenerator(name = "uuid", strategy = "uuid")
    private String detailId;

    /** 订单ID. */
    private String orderId;

    /** 商品ID. */
    private String productId;

    /** 商品名称. */
    private String productName;

    /** 当前价格. */
    private BigDecimal productPrice;

    /** 数量. */
    private Integer productQuantity;

    /** 商品小图. */
    private String productIcon;

    /** 创建时间. */
    private Date createTime;

    /** 修改时间. */
    private Date updateTime;

}
