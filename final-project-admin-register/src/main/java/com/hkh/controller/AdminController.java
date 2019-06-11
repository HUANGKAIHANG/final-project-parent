package com.hkh.controller;

import com.hkh.model.Admin;
import com.hkh.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HUANG Kaihang
 * @create 2019/6/4 21:06
 * @update 2019/6/7 15:48
 */

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public String doReg(Admin admin) {
		adminService.save(admin);
		return "doReg";
	}
}
