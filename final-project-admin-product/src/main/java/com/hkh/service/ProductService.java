package com.hkh.service;

import com.hkh.event.ProductEventPublisher;
import com.hkh.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HUANG Kaihang
 * @create 2019/6/9 20:16
 * @update 2019/6/11 15:45
 */

@Service
public class ProductService {

	@Autowired
	private ProductEventPublisher productEventPublisher;

	public void save(Product product) {
		productEventPublisher.publish(product);
	}

	public void edit(Product product, boolean fileRequired) {
		productEventPublisher.publishEdit(product, fileRequired);
	}

}
