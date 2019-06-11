package com.hkh.controller;

import com.hkh.model.User;
import com.hkh.service.UserService;
import com.hkh.util.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;

/**
 * @author HUANG Kaihang
 * @create 2019/6/11 20:52
 * @update 2019/6/11 20:52
 */

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(User user, /*HttpServletRequest request, HttpServletResponse response,*/ HttpSession session) {
		if (userService.checkLogin(user)) {
			user = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
			UserUtil.saveUserToSession(session, user);
			/*log.info("是否记住登录用户：{}",request.getParameter("remember"));
			if ("on".equals(request.getParameter("remember"))) {
				String uuid = UUID.randomUUID().toString();
				Remember remember = new Remember();
				remember.setId(uuid);
				remember.setUser(user);
				remember.setAddTime(new Date());
				rememberService.add(remember);
				CookieUtil.addCookie(response, appConfig.USER_COOKIE_NAME, uuid, appConfig.USER_COOKIE_AGE);
			} else {
				CookieUtil.removeCookie(response, appConfig.USER_COOKIE_NAME);
			}*/
			log.info("\nUSER [{}] login successful via session {}", user.getUsername(), session.getId());
			return "doLogin";
		}
		return "errorPwd";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session/*,HttpServletResponse response*/) {
		UserUtil.deleteUserFromSession(session);
//		CookieUtil.removeCookie(response, appConfig.USER_COOKIE_NAME);
		return "logout";
	}
}
