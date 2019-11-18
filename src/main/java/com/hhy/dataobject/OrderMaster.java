package com.hhy.dataobject;

import com.hhy.enums.OrderStatusEnum;
import com.hhy.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    /** 订单ID. */
    @Id
    //@GeneratedValue(generator = "uuid")
    //@GenericGenerator(name = "uuid",strategy = "uuid")
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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态,默认为0未支付. */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 创建时间. */
    private Date createTime;

    /** 修改时间. */
    private Date updateTime;

    /*
    @Transient//数据库对应时忽略该字段
    private List<OrderDetail> orderDetails;
    */
}
