package com.hkh.util;

import com.hkh.common.Constants;
import com.hkh.model.Admin;

import javax.servlet.http.HttpSession;

/**
 * @author HUANG Kaihang
 * @create 2019/6/7 15:51
 * @update 2019/6/7 15:51
 */

public class AdminUtil {

	public static final String ADMIN = Constants.LOGIN_ADMIN;

	public static void saveAdminToSession(HttpSession session, Admin admin) {
		deleteAdminFromSession(session);
		session.setAttribute(ADMIN,admin);
	}

	public static void deleteAdminFromSession(HttpSession session) {
		session.removeAttribute(ADMIN);
	}
}
