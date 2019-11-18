package com.hhy.repository;

import com.hhy.dataobject.OrderMaster;
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
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "1000100001";

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("18187654321");
        orderMaster.setBuyerAddress("北京市天安门");
        orderMaster.setBuyerOpenid("1000100001");
        orderMaster.setOrderAmount(new BigDecimal(5.6));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenidTest() {
        Sort sort = Sort.by(Sort.Direction.ASC,"createTime");
        PageRequest pageRequest = PageRequest.of(0, 2,sort);
        Page<OrderMaster> masterPages = repository.findByBuyerOpenid(OPENID, pageRequest);
        Assert.assertNotEquals(0, masterPages.getTotalElements());
    }
}