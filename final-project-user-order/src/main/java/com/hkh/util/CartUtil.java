package com.hkh.util;

import com.hkh.common.Constants;
import com.hkh.model.OrderItem;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HUANG Kaihang
 * @create 2019/6/13 15:16
 * @update 2019/6/13 15:16
 */

public class CartUtil {

	public static final String CART = Constants.CART;

	public static List<OrderItem> getOrderItemFromCart(HttpSession session) {
		Map<Integer, CartItem> cartItemMap = (HashMap<Integer, CartItem>) session.getAttribute(CART);
		if (cartItemMap == null)
			cartItemMap = new HashMap<Integer, CartItem>();
		List<OrderItem> oiList = new ArrayList<OrderItem>();
		for (CartItem ci : cartItemMap.values()) {
			OrderItem oi = new OrderItem();
			oi.setProduct(ci.getProduct());
			oi.setProductId(ci.getProduct().getId());
			oi.setQuantity(ci.getTotal());
			oiList.add(oi);
		}
		return oiList;
	}

	public static synchronized void cleanCart(HttpSession session) {
		Map<Integer, CartItem> cartItemMap = (HashMap<Integer, CartItem>) session.getAttribute(CART);
		if (cartItemMap != null) {
			cartItemMap.clear();
		}
		session.setAttribute(CART, cartItemMap);
	}
}
