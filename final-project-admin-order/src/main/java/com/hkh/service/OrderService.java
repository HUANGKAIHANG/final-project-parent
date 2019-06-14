package com.hkh.service;

import com.hkh.client.OrderFeignClient;
import com.hkh.common.Page;
import com.hkh.event.OrderEventPublisher;
import com.hkh.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public List<Order> findOrders(Page<Order> page, int p, int ps) {
		Page<Order> temp = orderDao.findOrders(p, ps);
		page = temp;
		/*page.setResult(temp.getResult());
		page.setTotalCount(temp.getTotalCount());*/
		return page.getResult();
	}

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

}
