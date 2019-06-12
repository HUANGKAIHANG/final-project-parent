package com.hkh.service;

import com.hkh.client.ProductFeignClient;
import com.hkh.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HUANG Kaihang
 * @create 2019/6/12 20:33
 * @update 2019/6/12 20:33
 */

@Service
public class ProductService {

	@Autowired
	ProductFeignClient productDao;

	public Product findById(Integer id) {
		return productDao.getOne(id);
	}

}
