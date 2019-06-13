package com.hkh.controller;

import com.hkh.common.Constants;
import com.hkh.common.JsonResult;
import com.hkh.common.Page;
import com.hkh.model.Order;
import com.hkh.model.OrderItem;
import com.hkh.model.User;
import com.hkh.model.UserAddress;
import com.hkh.service.OrderService;
import com.hkh.util.CartUtil;
import com.hkh.util.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author HUANG Kaihang
 * @create 2019/6/13 14:31
 * @update 2019/6/13 14:31
 */

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

	@Autowired
	OrderService orderService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Page<Order> list(HttpSession session, HttpServletRequest request) {
		User user = UserUtil.getUserFromSession(session);
		Page<Order> page = new Page<Order>(request);
		orderService.findOrders(page, user.getId());
		return page;
	}

	// get address list with user and let user to choose one address for purchase
	/*@RequestMapping(value = "/purchase", method = RequestMethod.GET)
	public String purchase(Model model, HttpSession session) {
		User user = userService.findOne(UserUtil.getUserFromSession(session).getId());
		List<UserAddress> userAddressList = user.getAddresses();
		System.out.println("userAddressList size:"+userAddressList.size());
		model.addAttribute("addressList", userAddressList);
		return "order/orderPurchase";
	}*/

	@RequestMapping(value = "/ordering", method = RequestMethod.POST)
	public String ordering(UserAddress address, HttpSession session) {
		Order order = new Order();
		order.setCreateTime(new Date());
//		address.setUser(UserUtil.getUserFromSession(session));
		address.setUserId(UserUtil.getUserFromSession(session).getId());
		order.setOrderNumber(new DateTime().toString("yyyyMMddHHmmSS"));
		order.setStatus(Constants.OrderStatus.WAIT_PAY);
		List<OrderItem> oiList = CartUtil.getOrderItemFromCart(session);
		BigDecimal totalSum = new BigDecimal("0");
		for (OrderItem oi : oiList) {
			totalSum = totalSum.add(new BigDecimal(oi.getProduct().getPoint() * oi.getQuantity()));
			oi.setOrder(order);
		}
		order.setTotalPrice(totalSum.doubleValue());
		order.setFinalPrice(totalSum.doubleValue());
		order.setOrderItems(oiList);
		order.setUserId(UserUtil.getUserFromSession(session).getId());
		order.setAddress(address.getAddress());
		order.setZipcode(address.getZipcode());
		order.setConsignee(address.getConsignee());
		order.setPhone(address.getPhone());
		orderService.addOrder(order, oiList, address);
		CartUtil.cleanCart(session);
		return "ordering";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Order viewOrder(@PathVariable Integer id) {
		return orderService.findById(id);
	}

	@RequestMapping(value = "/pay/{id}", method = RequestMethod.GET)
	public JsonResult pay(@PathVariable(value = "id") Integer orderId, HttpSession session) {
		JsonResult result = new JsonResult();
		if (orderService.checkOwned(orderId, UserUtil.getUserFromSession(session).getId())) {
			orderService.pay(orderId);
			result.setToSuccess();
		} else {
			result.setToFail();
		}
		return result;
	}

	@RequestMapping(value = "/cancel/{id}", method = RequestMethod.GET)
	public JsonResult cancel(@PathVariable(value = "id") Integer orderId, HttpSession session) {
		JsonResult result = new JsonResult();
		if (orderService.checkOwned(orderId, UserUtil.getUserFromSession(session).getId())) {
			orderService.updateOrderStatus(orderId, Constants.OrderStatus.DELETED);
			result.setToSuccess();
		} else {
			result.setToFail();
		}
		return result;
	}

	@RequestMapping(value = "/confirm/{id}", method = RequestMethod.GET)
	public JsonResult confirm(@PathVariable(value = "id") Integer orderId, HttpSession session) {
		JsonResult result = new JsonResult();
		if (orderService.checkOwned(orderId, UserUtil.getUserFromSession(session).getId())) {
			orderService.updateOrderStatus(orderId, Constants.OrderStatus.ENDED);
			result.setToSuccess();
		} else {
			result.setToFail();
		}
		return result;
	}
}
