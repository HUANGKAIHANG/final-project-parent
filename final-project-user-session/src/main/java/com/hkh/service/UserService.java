package com.hkh.service;

import com.hkh.model.User;
import com.hkh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author HUANG Kaihang
 * @create 2019/6/11 21:03
 * @update 2019/6/11 21:03
 */

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userDao;

	public void save(User user) {
		userDao.save(user);
	}

	public boolean checkLogin(User user) {
		user = userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		return user != null;
	}

	public User findByUsernameAndPassword(String username, String password) {
		User user = userDao.findByUsernameAndPassword(username, password);
		return user;
	}
}
