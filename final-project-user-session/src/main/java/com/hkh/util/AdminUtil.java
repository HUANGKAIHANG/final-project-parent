package com.hkh.util;

import com.hkh.common.Constants;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import javax.servlet.http.HttpSession;

/**
 * @author HUANG Kaihang
 * @create 2019/6/11 21:17
 * @update 2019/6/11 21:17
 */
public class AdminUtil {

	public static final String ADMIN = Constants.LOGIN_ADMIN;

	public static void deleteAdminFromSession(HttpSession session) {
		session.removeAttribute(ADMIN);
	}
}
