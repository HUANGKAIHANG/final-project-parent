package com.hkh.repository;

import com.hkh.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author HUANG Kaihang
 * @create 2019/6/11 21:04
 * @update 2019/6/11 21:04
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByUsernameAndPassword(String username, String password);

//	public User  findByUsername(String username);
}
