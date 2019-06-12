package com.hkh.util;

import com.hkh.common.Constants;
import com.hkh.model.User;

import javax.servlet.http.HttpSession;

/**
 * @author HUANG Kaihang
 * @create 2019/6/12 15:56
 * @update 2019/6/12 15:56
 */

public class UserUtil {

	public static final String USER = Constants.LOGIN_USER;

	public static User getUserFromSession(HttpSession session) {
		Object attribute = session.getAttribute(USER);
		return attribute == null ? null : (User) attribute;
	}
}
