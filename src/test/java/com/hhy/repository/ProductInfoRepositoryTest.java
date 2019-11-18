package com.hhy.repository;

import com.hhy.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void findByProductStatus(){
        List<ProductInfo> productInfoList = repository.findByProductStatus(0);
        Assert.assertEquals(2, productInfoList.size());
    }

    @Test
    public void findByProductIdInTest(){
        List<String> productIds = new ArrayList<>();
        productIds.add("4028b8816e25940a016e25940f150000");
        productIds.add("4028b8816e25a180016e25a184ee0000");
        List<ProductInfo> productInfoList = repository.findByProductIdIn(productIds);
        Assert.assertEquals(2, productInfoList.size());
    }

    @Test
    public void findOneTest(){
        Optional<ProductInfo> productInfoOptional = repository.findById("4028b8816e25940a016e25940f150000");
        if (productInfoOptional.isPresent()) {
            Assert.assertNotNull(productInfoOptional.get());
        } else {
            System.out.println("not exist");
        }
    }

    @Test
    public void saveTest(){
        ProductInfo info = new ProductInfo();
        info.setProductName("大米粥");
        info.setProductPrice(new BigDecimal(2.5));
        info.setProductStock(20);
        info.setProductDescription("粥的一种");
        info.setProductIcon("xxx.jpg");
        info.setProductStatus(0);
        info.setCategoryType(2);
        ProductInfo result = repository.save(info);
        Assert.assertNotNull(result);
    }

}