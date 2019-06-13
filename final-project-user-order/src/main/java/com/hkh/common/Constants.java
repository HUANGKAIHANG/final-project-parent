package com.hkh.common;

/**
 * @author HUANG Kaihang
 * @create 2019/6/13 14:54
 * @update 2019/6/13 14:54
 */

public class Constants {

	public static final String LOGIN_USER = "login_user";

	public static final String CART = "cart";

	public static class OrderStatus {
		public static final Integer WAIT_PAY = 0;
		public static final Integer PAYED = 1;
		public static final Integer SHIPPED = 2;
		public static final Integer DELETED = 3;
		public static final Integer ENDED = 4;
	}
}
