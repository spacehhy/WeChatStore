package com.hhy.service.impl;

import com.hhy.dataobject.ProductInfo;
import com.hhy.dto.CartDTO;
import com.hhy.enums.ProductStatusEnum;
import com.hhy.enums.ResultEnum;
import com.hhy.exception.SellException;
import com.hhy.repository.ProductInfoRepository;
import com.hhy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        Optional<ProductInfo> productInfoOptional = repository.findById(productId);
        if (productInfoOptional.isPresent()) {
            return productInfoOptional.get();
        } else {
            return null;
        }
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        Sort sort = Sort.by("createTime").descending();
        return repository.findAll(pageable);
    }

    @Override
    public List<ProductInfo> findAllByIds(List<String> productIds) {
        return repository.findByProductIdIn(productIds);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> productInfoOptional = repository.findById(cartDTO.getProductId());
            if (productInfoOptional.isPresent()) {
                ProductInfo productInfo = productInfoOptional.get();
                Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
                productInfo.setProductStock(result);
                repository.save(productInfo);
            } else {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> productInfoOptional = repository.findById(cartDTO.getProductId());
            if (productInfoOptional.isPresent()) {
                ProductInfo productInfo = productInfoOptional.get();
                Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
                if (result < 0) {
                    throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
                }
                productInfo.setProductStock(result);
                repository.save(productInfo);
            } else {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
        }
    }

}
