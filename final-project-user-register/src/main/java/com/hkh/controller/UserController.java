package com.hkh.controller;

import com.hkh.model.User;
import com.hkh.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author HUANG Kaihang
 * @create 2019/6/11 20:15
 * @update 2019/6/11 20:15
 */

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping(value = "/reg")
	public String doReg(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			for (ObjectError or : result.getAllErrors()) {
				log.warn("VALIDATION type:{}\nERROR message:{}", or.getCode(), or.getDefaultMessage());
			}
			return "hasErrors: " + result.hasErrors();
		}
		userService.save(user);
		return "doReg";
	}

}
