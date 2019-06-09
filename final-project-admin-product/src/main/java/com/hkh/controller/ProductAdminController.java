package com.hkh.controller;

import com.hkh.model.Product;
import com.hkh.service.ProductService;
import com.hkh.util.AdminUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author HUANG Kaihang
 * @create 2019/6/9 20:14
 * @update 2019/6/9 20:14
 */

@RestController
@RequestMapping(value = "/admin/product")
public class ProductAdminController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String doNew(Product product, HttpSession session, @RequestParam("imgFile") MultipartFile file) {
		product.setInputUser(AdminUtil.getAdminFromSession(session));
		product.setCreateTime(new Date());
		productService.save(product, file, generateFilePath(session));
		return "doNew";
	}

	private String generateFilePath(HttpSession session) {
		return session.getServletContext().getRealPath("/upload");
	}

}
