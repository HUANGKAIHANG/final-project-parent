package com.hkh.service;

import com.hkh.client.ProductFeignClient;
import com.hkh.common.Constants;
import com.hkh.common.Page;
import com.hkh.model.Order;
import com.hkh.model.OrderItem;
import com.hkh.model.Product;
import com.hkh.model.UserAddress;
import com.hkh.repository.OrderItemRepository;
import com.hkh.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author HUANG Kaihang
 * @create 2019/6/13 14:56
 * @update 2019/6/13 14:56
 */

@Service
@Transactional
public class OrderService {

	@Autowired
	OrderRepository orderDao;

	@Autowired
	OrderItemRepository orderItemDao;

	@Autowired
	ProductFeignClient productDao;

	public List<Order> findOrders(Page<Order> page, Integer userId) {
		List<Order> orderList = orderDao.findByUserId(userId, page.getPageable()).getContent();
		for (Order order : orderList) {
			List<OrderItem> orderItemList = order.getOrderItems();
			for (OrderItem orderItem : orderItemList) {
				orderItem.setProduct(getOneProduct(orderItem.getProductId()));
			}
		}
		page.setResult(orderList);
//		page.setResult(orderDao.findByUserId(userId, page.getPageable()).getContent());
		page.setTotalCount(orderDao.countByUserId(userId));
		return null;
	}

	public void addOrder(Order order, List<OrderItem> orderItemList, UserAddress userAddress) {
		//drop above rule. the user can only use exists address to order
//		userAddressService.save(userAddress);
		save(order);
		for (OrderItem orderItem : orderItemList) {
			orderItemDao.save(orderItem);
		}
	}

	public void save(Order order) {
		orderDao.save(order);
	}

	public Order findById(Integer id) {
		Order order = orderDao.getOne(id);
		List<OrderItem> orderItemList = order.getOrderItems();
		for (OrderItem orderItem : orderItemList) {
			orderItem.setProduct(getOneProduct(orderItem.getProductId()));
		}
		return order;
//		return orderDao.getOne(id);
	}

	public boolean checkOwned(Integer orderId, Integer userId) {
		return orderDao.getOne(orderId).getUserId().equals(userId);
	}

	public void pay(Integer orderId) {
		Order order = orderDao.getOne(orderId);
		order.setStatus(Constants.OrderStatus.PAYED);
		order.setPayTime(new Date());
		orderDao.save(order);
	}

	public void updateOrderStatus(Integer orderID, Integer status) {
		Order order = orderDao.getOne(orderID);
		order.setStatus(status);
		if (status == Constants.OrderStatus.PAYED) {
			order.setPayTime(new Date());
		} else if (status == Constants.OrderStatus.SHIPPED) {
			order.setShipTime(new Date());
		} else if (status == Constants.OrderStatus.ENDED) {
			order.setConfirmTime(new Date());
		}
		orderDao.save(order);
	}

	public Product getOneProduct(Integer id) {
		return productDao.getOne(id);
	}
}
