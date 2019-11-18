package com.hhy.service.impl;

import com.hhy.dataobject.ProductCategory;
import com.hhy.repository.ProductCategoryRepository;
import com.hhy.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        Optional<ProductCategory> productCategoryOptional = repository.findById(categoryId);
        if (productCategoryOptional.isPresent()) {
            return productCategoryOptional.get();
        } else {
            return null;
        }
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
