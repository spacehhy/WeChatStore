package com.hhy.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品详情
 */
@Data
public class ProductInfoVO {

    @JsonProperty("id")
    private String ProductId;

    @JsonProperty("name")
    private String ProductName;

    @JsonProperty("price")
    private BigDecimal ProductPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;
}
