package com.hkh.util;

import com.hkh.common.Constants;
import com.hkh.model.Admin;

import javax.servlet.http.HttpSession;

/**
 * @author HUANG Kaihang
 * @create 2019/6/9 20:13
 * @update 2019/6/9 20:13
 */

public class AdminUtil {

	public static final String ADMIN = Constants.LOGIN_ADMIN;

	public static Admin getAdminFromSession(HttpSession session) {
		Object attribute = session.getAttribute(ADMIN);
		return attribute == null ? null : (Admin) attribute;
	}
}
