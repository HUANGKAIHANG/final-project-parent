package com.hkh.util;

import com.hkh.common.Constants;

import javax.servlet.http.HttpSession;

/**
 * @author HUANG Kaihang
 * @create 2019/6/11 21:20
 * @update 2019/6/11 21:20
 */
public class UserUtil {

	public static final String USER = Constants.LOGIN_USER;

	public static void deleteUserFromSession(HttpSession session) {
		session.removeAttribute(USER);
	}
}
