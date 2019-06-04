package com.hkh.controller;

import com.hkh.common.ResultBase;
import com.hkh.model.Admin;
import com.hkh.service.AdminRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HUANG Kaihang
 * @create 2019/6/4 21:06
 * @update 2019/6/4 21:06
 */

@RestController
@RequestMapping("/admin")
public class AdminRegisterController {

	@Autowired
	private AdminRegisterService adminRegisterService;

	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public ResultBase adminRegister(Admin admin) {
		adminRegisterService.publishAdmin(admin);
		ResultBase resultBase = new ResultBase();
		resultBase.setToSuccess(admin.getUsername() + " created successful.");
		return resultBase;
	}
}
