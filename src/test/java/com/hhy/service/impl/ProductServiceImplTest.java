package com.hhy.service.impl;

import com.hhy.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl service;

    @Test
    public void findOneTest() {
        ProductInfo productInfo = service.findOne("4028b8816e25940a016e25940f150000");
        Assert.assertNotNull(productInfo);
    }

    @Test
    public void findUpAllTest() {
        List<ProductInfo> productInfoList = service.findUpAll();
        Assert.assertEquals(2, productInfoList.size());
    }

    @Test
    public void findAllTest() {
        Sort sort = Sort.by("createTime").descending();
        Page<ProductInfo> productInfoPage = service.findAll(PageRequest.of(0, 3, sort));
        //System.out.println(productInfoPage.getTotalElements());
        Assert.assertNotEquals(0, productInfoPage.getTotalElements());
    }

    @Test
    public void saveTest() {
        ProductInfo info = new ProductInfo();
        info.setProductName("牛肉粥");
        info.setProductPrice(new BigDecimal(4.9));
        info.setProductStock(30);
        info.setProductDescription("粥的一种");
        info.setProductIcon("xxx.jpg");
        info.setProductStatus(1);
        info.setCategoryType(2);
        ProductInfo productInfo = service.save(info);
        Assert.assertNotNull(productInfo);
    }
}