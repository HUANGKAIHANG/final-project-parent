package com.hkh.event;

import com.hkh.common.Constants;
import com.hkh.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @author HUANG Kaihang
 * @create 2019/6/14 16:33
 * @update 2019/6/14 16:33
 */

@EnableBinding(OrderEventSink.class)
@Slf4j
public class OrderEventHandler {

	@Autowired
	private OrderService orderService;

	@StreamListener("orderEventInput")
	public void handle(OrderEventModel model) {
		log.info("\nRECEIVED order {}", model);
		if ("delete".equals(model.getOperation())) {
			delete(model.getId());
		} else if ("cancel".equals(model.getOperation())) {
			cancel(model.getId());
		} else if ("ship".equals(model.getOperation())) {
			ship(model.getId());
		}
	}

	public void delete(Integer id) {
		orderService.deleteOrder(id);
	}

	public void cancel(Integer orderId) {
		orderService.updateOrderStatus(orderId, Constants.OrderStatus.DELETED);
	}

	public void ship(Integer orderId) {
		orderService.updateOrderStatus(orderId, Constants.OrderStatus.SHIPPED);
	}
}
