package com.hhy.repository;

import com.hhy.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

    List<OrderDetail> findByOrderIdIn(List<String> orderIdList);

    List<OrderDetail> findByOrderId(String orderId);
}
