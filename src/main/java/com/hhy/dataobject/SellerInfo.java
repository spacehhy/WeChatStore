package com.hhy.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 卖家详情
 */
@Entity
@Data
public class SellerInfo {

    /** 卖家ID. */
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid")
    private String sellerId;

    /** 卖家用户名. */
    private String username;

    /** 卖家密码. */
    private String password;

    /** 卖家OpenID. */
    private String openid;

}
