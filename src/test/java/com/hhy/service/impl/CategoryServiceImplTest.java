package com.hhy.service.impl;

import com.hhy.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    void findOne() {
        ProductCategory productCategory = categoryService.findOne(1);
        Assert.assertEquals("热销榜", productCategory.getCategoryName());
    }

    @Test
    void findAll() {
        List<ProductCategory> productCategoryList = categoryService.findAll();
        Assert.assertNotEquals(0, productCategoryList.size());
    }

    @Test
    void findByCategoryTypeIn() {
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(Arrays.asList(2, 4));
        Assert.assertNotEquals(0, productCategoryList.size());
    }

    @Test
    @Transactional
    void save() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("测试类目");
        productCategory.setCategoryType(6);
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertNotNull(result);

    }
}