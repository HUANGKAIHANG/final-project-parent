package com.hkh.service;

import com.hkh.client.OrderFeignClient;
import com.hkh.common.Page;
import com.hkh.event.OrderEventPublisher;
import com.hkh.model.Order;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HUANG Kaihang
 * @create 2019/6/14 15:55
 * @update 2019/6/14 15:55
 */

@Service
public class OrderService {

	@Autowired
	OrderFeignClient orderDao;

	@Autowired
	private OrderEventPublisher orderEventPublisher;

	@HystrixCommand(
			fallbackMethod = "buildFallbackOrderPage",
			threadPoolKey = "adminOrderServiceFindOrdersThreadPool",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds"
							, value = "3000")
			}
	)
	public Page<Order> findOrders(Page<Order> page, int p, int ps) {
		Page<Order> temp = orderDao.findOrders(p, ps);
		page.setResult(temp.getResult());
		page.setTotalCount(temp.getTotalCount());
		return null;
	}

	@HystrixCommand(
			fallbackMethod = "buildFallbackOrder",
			threadPoolKey = "adminOrderServiceFindByIdThreadPool",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds"
							, value = "3000")
			}
	)
	public Order findById(Integer id) {
		return orderDao.getOne(id);
	}

	public void deleteOrder(Integer id) {
		orderEventPublisher.publish(id, "delete");
	}

	public void cancelOrder(Integer id) {
		orderEventPublisher.publish(id, "cancel");
	}

	public void shipOrder(Integer id) {
		orderEventPublisher.publish(id, "ship");
	}

	private Order buildFallbackOrder(Integer id) {
		Order order = Order.builder()
				.id(id)
				.orderNumber("Sorry no Order information currently available.")
				.build();
		return order;
	}

	private Page<Order> buildFallbackOrderPage(Page<Order> page, int p, int ps) {
		List<Order> list = new ArrayList<>();
		Order order = Order.builder()
				.orderNumber("Sorry no Order information currently available.")
				.build();
		list.add(order);
		page.setResult(list);
		page.setTotalCount(1);
		page.setPageNo(p);
		page.setPageSize(ps);
		return null;
	}

}
