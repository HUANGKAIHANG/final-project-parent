package com.hkh.controller;

import com.hkh.common.Constants;
import com.hkh.model.Picture;
import com.hkh.model.Product;
import com.hkh.service.ProductService;
import com.hkh.util.AdminUtil;
import com.hkh.util.Image;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

/**
 * @author HUANG Kaihang
 * @create 2019/6/9 21:03
 * @update 2019/6/11 15:45
 */

@RestController
@RequestMapping(value = "/admin/product")
@Slf4j
public class ProductAdminController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String doNew(Product product, HttpSession session, @RequestParam("imgFile") MultipartFile file) {
		if (file != null && !file.isEmpty()) {
			uploadImage(product, session, file);
		}
		product.setInputUser(AdminUtil.getAdminFromSession(session));
		product.setCreateTime(new Date());
		productService.save(product);
		return "doNew";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String doEdit(Product product, HttpSession session, @RequestParam(name = "file", required = false) MultipartFile file) {
		boolean fileRequired = false;
		if (file != null && !file.isEmpty()) {
			uploadImage(product, session, file);
			fileRequired = true;
		}
		product.setInputUser(AdminUtil.getAdminFromSession(session));
		productService.edit(product, fileRequired);
		return "doEdit";
	}


	private void uploadImage(Product product, HttpSession session, MultipartFile file) {
		String fileName = generateFileName();
		String path = generateFilePath(session);
		String serverFile = path + "/" + fileName;
		Picture picture = uploadAndSaveImg(session, file, fileName, path, serverFile);
		product.setMasterPic(picture);
	}

	private String generateFileName() {
		return new Date().getTime() + ".jpg";
	}

	private String generateFilePath(HttpSession session) {
		return session.getServletContext().getRealPath("/upload");
	}

	private Picture uploadAndSaveImg(HttpSession session, MultipartFile file, String fileName, String path, String serverFile) {
		Picture picture = new Picture();
		try {
			log.info("PATH : {}", path);
			log.info("FILE name : {}", fileName);
			log.info("SERVER file path: {}", serverFile);
			if (!new File(path).exists()) {
				new File(path).mkdirs();
			}
			if (!new File(serverFile).exists()) {
				new File(serverFile).createNewFile();
			}
			byte[] bytes = file.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(serverFile)));
			stream.write(bytes);
			stream.close();
			Image image = new Image(serverFile);
			image.resize(Constants.IMG_WIDTH, Constants.IMG_HEIGHT);
			image.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		picture.setMemo("商品上传");
		picture.setTitle("商品上传");
		picture.setUpdateTime(new Date());
		picture.setUrl("/upload/" + fileName);
		picture.setUpdateAdmin(AdminUtil.getAdminFromSession(session));
		picture.setUpdateAdminId(AdminUtil.getAdminFromSession(session).getId());
		return picture;
	}

}
