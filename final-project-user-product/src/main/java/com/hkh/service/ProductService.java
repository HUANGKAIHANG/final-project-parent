package com.hkh.service;

import com.hkh.model.Product;
import com.hkh.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author HUANG Kaihang
 * @create 2019/6/9 21:07
 * @update 2019/6/9 21:07
 */

@Service
@Transactional
public class ProductService {

	@Autowired
	ProductRepository productDao;

	public void save(Product product) {
		productDao.save(product);
	}
}
