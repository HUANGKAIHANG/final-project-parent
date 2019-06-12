package com.hkh.util;

import com.hkh.common.Constants;
import com.hkh.model.Product;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HUANG Kaihang
 * @create 2019/6/12 20:38
 * @update 2019/6/12 20:38
 */

public class CartUtil {

	public static final String CART = Constants.CART;

	public static synchronized void saveProductToCart(HttpSession session, Product product, Integer total) {
		Map<Integer, CartItem> cartItemMap = (HashMap<Integer, CartItem>) session.getAttribute(CART);
		CartItem ci = new CartItem(product, total);
		if (cartItemMap == null) {
			cartItemMap = new HashMap<Integer, CartItem>();
		}
		if (cartItemMap.containsKey(product.getId())) {
			CartItem currentCi = cartItemMap.get(product.getId());
			currentCi.setTotal(currentCi.getTotal() + total);
			cartItemMap.put(product.getId(), currentCi);
		} else {
			cartItemMap.put(product.getId(), ci);
		}
		session.setAttribute(CART, cartItemMap);
	}

	public static synchronized int getCartSize(HttpSession session) {
		Map<Integer, CartItem> cartItemMap = (Map<Integer, CartItem>) session.getAttribute(CART);
		return cartItemMap.size();
	}

	public static synchronized void deleteProductFromCart(HttpSession session, Integer productId) {
		Map<Integer, CartItem> cartItemMap = (HashMap<Integer, CartItem>) session.getAttribute(CART);
		if (cartItemMap != null) {
			cartItemMap.remove(productId);
		}
		session.setAttribute(CART, cartItemMap);
	}

	public static synchronized void cleanCart(HttpSession session) {
		Map<Integer, CartItem> cartItemMap = (HashMap<Integer, CartItem>) session.getAttribute(CART);
		if (cartItemMap != null) {
			cartItemMap.clear();
		}
		session.setAttribute(CART, cartItemMap);
	}
}
