package com.hkh.repository;

import com.hkh.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author HUANG Kaihang
 * @create 2019/6/13 15:29
 * @update 2019/6/13 15:29
 */

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

	void deleteByOrderId(Integer orderId);
}
