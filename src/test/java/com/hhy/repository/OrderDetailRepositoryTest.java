package com.hhy.repository;

import com.hhy.dataobject.OrderDetail;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId("4028b8816e437e03016e437e09bb0000");
        orderDetail.setProductIcon("http://xxxx.jpg");
        orderDetail.setProductId("4028b8816e25f331016e25f337740000");
        orderDetail.setProductName("牛肉粥");
        orderDetail.setProductPrice(new BigDecimal(4.9));
        orderDetail.setProductQuantity(3);

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderIdInTest(){
        List<String> orderIdList = Arrays.asList("1573118109931767258");
        List<OrderDetail> result = repository.findByOrderIdIn(orderIdList);
        log.info(" 【in查询】 result={}",result);
        Assert.assertNotEquals(0,result.size() );
    }


    @Test
    public void findByOrderIdTest() {
        List<OrderDetail> result = repository.findByOrderId("4028b8816e437e03016e437e09bb0000");
        Assert.assertEquals(1, result.size());
    }
}