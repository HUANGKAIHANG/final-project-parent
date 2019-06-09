package com.hkh.service;

import com.hkh.model.Admin;
import com.hkh.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author HUANG Kaihang
 * @create 2019/6/7 15:57
 * @update 2019/6/9 14:44
 */

@Service
@Transactional
public class AdminService {

	@Autowired
	private AdminRepository adminDao;

	public boolean checkLogin(Admin admin) {
		return findByUsernameAndPassword(admin.getUsername(), admin.getPassword()) == null ? false : true;
	}

	public Admin findByUsernameAndPassword(String username, String password) {
		return adminDao.findByUsernameAndPassword(username, password);
	}

	public void save(Admin admin) {
		adminDao.save(admin);
	}
}
