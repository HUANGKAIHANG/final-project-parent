package com.hkh.repository;

import com.hkh.model.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HUANG Kaihang
 * @create 2019/6/12 15:44
 * @update 2019/6/12 15:44
 */

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, Integer> {
//	List<UserAddress> findByUser(User user);

	List<UserAddress> findByUserId(Integer userId);
}
