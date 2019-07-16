package com.hkh.controller;

import com.hkh.common.JsonResult;
import com.hkh.model.Product;
import com.hkh.service.ProductService;
import com.hkh.util.CartUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author HUANG Kaihang
 * @create 2019/6/12 20:32
 * @update 2019/6/12 20:32
 */

@RestController
@RequestMapping("/cart")
@Slf4j
public class CartController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/add/{id}/{total}")
	public JsonResult addToCart(@PathVariable Integer id, @PathVariable Integer total, HttpSession session) {
		long startTime = System.currentTimeMillis();
		Product product = productService.findById(id);
		CartUtil.saveProductToCart(session, product, total);
		JsonResult result = new JsonResult();
		result.setToSuccess();
		long stopTime = System.currentTimeMillis();
		log.info("Performance: " + (stopTime - startTime) + "ms.");
		return result;
	}

	@RequestMapping(value = "/delete/{id}")
	public JsonResult deleteFromCart(@PathVariable(value = "id") Integer productId, HttpSession session) {
		CartUtil.deleteProductFromCart(session, productId);
		JsonResult result = new JsonResult();
		result.setToSuccess();
		return result;
	}

	@RequestMapping(value = "/deleteAll")
	public JsonResult deleteAllFromCart(HttpSession session) {
		CartUtil.cleanCart(session);
		JsonResult result = new JsonResult();
		result.setToSuccess();
		return result;
	}
}
