package com.hkh.controller;

import com.hkh.common.JsonResult;
import com.hkh.model.User;
import com.hkh.model.UserAddress;
import com.hkh.service.UserAddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.hkh.util.UserUtil.getUserFromSession;

/**
 * @author HUANG Kaihang
 * @create 2019/6/12 15:57
 * @update 2019/6/12 15:57
 */

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

	@Autowired
	UserAddressService userAddressService;

	@RequestMapping(value = "/profile")
	public User profile(HttpSession session) {
		User user = getUserFromSession(session);
		/*if (user == null) {
			return "redirect:/user/login?timeout=true";
		}*/
		return user;
	}

	@RequestMapping(value = "/userAddressList/{id}")
	public List<UserAddress> getUserAddressList(@PathVariable int id) {
		return userAddressService.findByUserId(id);
	}

	@RequestMapping(value = "/userAddress", method = RequestMethod.GET)
	public List<UserAddress> userAddress(HttpSession session) {
		List<UserAddress> userAddressList = userAddressService.findByUserId(getUserFromSession(session).getId());
		return userAddressList;
	}

	@RequestMapping(value = "/userAddress/add", method = RequestMethod.POST)
	public JsonResult doAddUserAddress(HttpSession session, UserAddress userAddress) {
//		userAddress.setUser(getUserFromSession(session));
		userAddress.setUserId(getUserFromSession(session).getId());
		userAddressService.save(userAddress);
		log.info("\nADDRESS {} saved successful.", userAddress);
		JsonResult result = new JsonResult();
		result.setToSuccess();
		return result;
	}

	@RequestMapping(value = "/userAddress/update", method = RequestMethod.POST)
	public String doUpdateUserAddress(UserAddress userAddress) {
		userAddressService.updateUserAddress(userAddress);
		return "success";
	}

	@RequestMapping(value = "/userAddress/{id}")
	public UserAddress findAddress(@PathVariable Integer id) {
		return userAddressService.findById(id);
	}

	@RequestMapping(value = "/userAddress/delete/{id}", method = RequestMethod.GET)
	public String delUserAddress(@PathVariable Integer id) {
		userAddressService.deleteById(id);
		log.info("\nADDRESS {} deleted successful.", id);
		return "success";
	}


}
