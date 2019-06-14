package com.hkh.client;

import com.hkh.common.Page;
import com.hkh.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author HUANG Kaihang
 * @create 2019/6/14 15:55
 * @update 2019/6/14 15:55
 */

@FeignClient("userorderservice")
public interface OrderFeignClient {

	@RequestMapping(
			method = RequestMethod.GET,
			value = "/admin/order/{p}/{ps}",
			consumes = "application/json"
	)
	Page<Order> findOrders(@PathVariable("p") int p, @PathVariable("ps") int ps);

	@RequestMapping(
			method = RequestMethod.GET,
			value = "/order/{id}",
			consumes = "application/json"
	)
	Order getOne(@PathVariable("id") Integer id);

}

