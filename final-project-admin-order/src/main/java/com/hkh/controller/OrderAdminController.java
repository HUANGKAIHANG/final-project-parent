package com.hkh.controller;

import com.hkh.common.JsonResult;
import com.hkh.common.Page;
import com.hkh.model.Order;
import com.hkh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author HUANG Kaihang
 * @create 2019/6/14 15:20
 * @update 2019/6/14 15:20
 */

@RestController
@RequestMapping("/admin/order")
public class OrderAdminController {

	@Autowired
	OrderService orderService;

	@RequestMapping(method = RequestMethod.GET)
	public Page<Order> adminList(HttpServletRequest request) {
		int p = 1;
		int ps = 10;
		if (request.getParameter("p") != null)
			p = Integer.parseInt(request.getParameter("p"));
		if (request.getParameter("ps") != null)
			ps = Integer.parseInt(request.getParameter("ps"));
		Page<Order> page = new Page<Order>(request);
		orderService.findOrders(page, p, ps);
		return page;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Order viewOrder(@PathVariable Integer id) {
		return orderService.findById(id);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public JsonResult delete(@PathVariable Integer id) {
		orderService.deleteOrder(id);
		JsonResult result = new JsonResult();
		result.setToSuccess();
		return result;
	}

	@RequestMapping(value = "/cancel/{id}", method = RequestMethod.GET)
	public JsonResult cancel(@PathVariable(value = "id") Integer orderId) {
		orderService.cancelOrder(orderId);
		JsonResult result = new JsonResult();
		result.setToSuccess();
		return result;
	}

	@RequestMapping(value = "/ship/{id}", method = RequestMethod.GET)
	public JsonResult ship(@PathVariable(value = "id") Integer orderId) {
		orderService.shipOrder(orderId);
		JsonResult result = new JsonResult();
		result.setToSuccess();
		return result;
	}


}
