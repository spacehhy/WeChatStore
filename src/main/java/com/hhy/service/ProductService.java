package com.hhy.service;

import com.hhy.dataobject.ProductInfo;
import com.hhy.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    ProductInfo findOne(String productId);

    /** 查询所有在架商品. */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    List<ProductInfo> findAllByIds(List<String> productIds);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);
}
