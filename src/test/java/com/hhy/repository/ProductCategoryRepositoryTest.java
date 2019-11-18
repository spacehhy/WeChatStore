package com.hhy.repository;

import com.hhy.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(1);
        Example<ProductCategory> example = Example.of(productCategory);
        Optional<ProductCategory> productCategoryOptional = repository.findOne(example);

        if (productCategoryOptional.isPresent()) {
            ProductCategory productCategoryResult = productCategoryOptional.get();
            System.out.println(productCategoryResult.toString());
        } else {
            // handle not found, return null or throw
            System.out.println("no exist!");
        }
    }

    @Test
    public void saveTest(){
        /*
        ProductCategory productCategory = new ProductCategory();
        //productCategory.setCategoryId(2);
        productCategory.setCategoryName("男生最爱");
        productCategory.setCategoryType(3);
        repository.save(productCategory);
        */

        /*
        Optional<ProductCategory> categoryOptional = repository.findById(2);
        if (categoryOptional.isPresent()) {
            ProductCategory productCategory = categoryOptional.get();
            productCategory.setCategoryType(10);
            repository.save(productCategory);
        } else {
            System.out.println("no exist");
        }
        */

        ProductCategory productCategory = new ProductCategory("女生最爱",4);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
        //Assert.assertNotEquals(null, result);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
        for (ProductCategory productCategory : result) {
            System.out.println(productCategory.getCategoryName());
            System.out.println(productCategory.getCategoryType());
        }
    }
}