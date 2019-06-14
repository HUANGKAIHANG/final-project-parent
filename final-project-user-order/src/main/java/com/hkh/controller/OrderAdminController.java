package com.hkh.controller;

import com.hkh.common.Page;
import com.hkh.model.Order;
import com.hkh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HUANG Kaihang
 * @create 2019/6/14 15:26
 * @update 2019/6/14 15:26
 */

@RestController
@RequestMapping("/admin/order")
public class OrderAdminController {

	@Autowired
	OrderService orderService;

	@RequestMapping(value = "/{p}/{ps}" ,method = RequestMethod.GET)
	public Page<Order> adminList(@PathVariable Integer p, @PathVariable Integer ps) {
		Page<Order> page = new Page<Order>(p,ps);
		orderService.findOrders(page);
		return page;
	}

}
