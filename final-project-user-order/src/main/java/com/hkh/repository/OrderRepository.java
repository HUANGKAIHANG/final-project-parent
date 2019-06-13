package com.hkh.repository;

import com.hkh.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author HUANG Kaihang
 * @create 2019/6/13 14:57
 * @update 2019/6/13 14:57
 */

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

//	@Query("from Order o where o.user.id=?1")
	@Query("from Order o where o.userId=?1")
	Page<Order> findByUserId(Integer id, Pageable pageable);

//	@Query("select count(o.id) from Order o where o.user.id=?1")
	@Query("select count(o.id) from Order o where o.userId=?1")
	long countByUserId(Integer userId);
}
