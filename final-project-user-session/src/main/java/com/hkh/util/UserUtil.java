package com.hkh.util;

import com.hkh.common.Constants;
import com.hkh.model.User;

import javax.servlet.http.HttpSession;

/**
 * @author HUANG Kaihang
 * @create 2019/6/11 21:13
 * @update 2019/6/11 21:13
 */

public class UserUtil {

	public static final String USER = Constants.LOGIN_USER;

	public static void saveUserToSession(HttpSession session, User user) {
		AdminUtil.deleteAdminFromSession(session);
		session.setAttribute(USER, user);
	}

	public static void deleteUserFromSession(HttpSession session) {
		session.removeAttribute(USER);
	}
}
