package com.hkh.repository;

import com.hkh.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author HUANG Kaihang
 * @create 2019/6/6 17:19
 * @update 2019/6/6 17:19
 */

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	public Admin findByUsernameAndPassword(String username, String password);

}
