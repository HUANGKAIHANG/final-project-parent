package com.hkh.service;

import com.hkh.common.Page;
import com.hkh.model.Product;
import com.hkh.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

	public List<Product> findProducts(Page<Product> page) {
		page.setResult(productDao.findAll(page.getPageable()).getContent());
		page.setTotalCount(productDao.count());
		return page.getResult();
	}

	public Product findById(Integer id) {
		return productDao.getOne(id);
	}
}
