package com.hkh.controller;

import com.hkh.common.Page;
import com.hkh.model.Product;
import com.hkh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author HUANG Kaihang
 * @create 2019/6/9 21:07
 * @update 2019/6/9 21:07
 */

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Page<Product> listProduct(HttpServletRequest request) {
		Page<Product> page = new Page<>(request);
		productService.findProducts(page);
		return page;
	}

	@RequestMapping(value = "/{id}")
	public Product showInfo(@PathVariable Integer id) {
		return productService.findById(id);
	}
}
