package com.hkh.service;

import com.hkh.common.Page;
import com.hkh.model.Product;
import com.hkh.repository.ProductRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

	@HystrixCommand(
			fallbackMethod = "buildFallbackProductPage",
			threadPoolKey = "productServiceFindProductsThreadPool",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds"
							, value = "1000")
			}
	)
	public List<Product> findProducts(Page<Product> page) {
		page.setResult(productDao.findAll(page.getPageable()).getContent());
		page.setTotalCount(productDao.count());
		return page.getResult();
	}

	@HystrixCommand(
			fallbackMethod = "buildFallbackProduct",
			threadPoolKey = "productServiceFindByIdThreadPool",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds"
							, value = "1000")
			}
	)
	public Product findById(Integer id) {
		return productDao.getOne(id);
	}

	private Product buildFallbackProduct(Integer id) {
		Product product = Product.builder()
				.id(id)
				.title("Sorry no Product information currently available.")
				.build();
		return product;
	}

	private List<Product> buildFallbackProductPage(Page<Product> page) {
		List<Product> list = new ArrayList<>();
		Product product = Product.builder()
				.title("Sorry no Product information currently available.")
				.build();
		list.add(product);
		page.setResult(list);
		page.setTotalCount(1);
		return list;
	}
}
