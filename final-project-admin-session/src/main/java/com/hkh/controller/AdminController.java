package com.hkh.controller;

import com.hkh.model.Admin;
import com.hkh.service.AdminService;
import com.hkh.util.AdminUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author HUANG Kaihang
 * @create 2019/6/7 15:45
 * @update 2019/6/7 15:45
 */

@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {

	@Autowired
	AdminService adminService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(Admin admin, HttpSession session) {
		if (adminService.checkLogin(admin)) {
			AdminUtil.saveAdminToSession(session, adminService.findByUsernameAndPassword(admin.getUsername(), admin.getPassword()));
			log.info("\nADMIN [{}] login successful via session {}", admin.getUsername(), session.getId());
			return "doLogin";
		}
		return "errorPwd";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String doLogout(HttpSession session) {
		AdminUtil.deleteAdminFromSession(session);
		return "doLogout";
	}
}
