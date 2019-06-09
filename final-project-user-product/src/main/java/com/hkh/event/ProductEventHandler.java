package com.hkh.event;

import com.hkh.common.Constants;
import com.hkh.model.Picture;
import com.hkh.model.Product;
import com.hkh.service.PictureService;
import com.hkh.service.ProductService;
import com.hkh.util.Image;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

/**
 * @author HUANG Kaihang
 * @create 2019/6/9 21:08
 * @update 2019/6/9 21:08
 */

@EnableBinding(ProductEventSink.class)
@Slf4j
public class ProductEventHandler {

	@Autowired
	private ProductService productService;

	@Autowired
	private PictureService pictureService;

	private static final String PRODUCT_ADD = Constants.PRODUCT_ADD;

	@StreamListener("productEventInput")
	public void handle(ProductEventModel model) {
		log.info("RECEIVED product {}", model);
		if (PRODUCT_ADD.equals(model.getOperation())) {

			MultipartFile file = model.getFile();

			Product product = Product.builder()
					.code(model.getCode())
					.createTime(model.getCreateTime())
					.model(model.getModel())
					.note(model.getNote())
					.point(model.getPoint())
					.stock(model.getStock())
					.title(model.getTitle())
					.inputUserId(model.getInputUser().getId())
					.build();

			if (file != null && !file.isEmpty()) {
				uploadImage(product, model.getFilePath(), file, model.getInputUser().getId());
			}
			add(product);
		} else {

		}
	}

	public void add(Product product) {
		productService.save(product);
	}

	/*public void delete(Integer id) {
		newsService.delNews(id);
	}*/


	private void uploadImage(Product product, String filePath, MultipartFile file, Integer updateAdminId) {
		String fileName = generateFileName();
		String path = filePath;
		String serverFile = path + "/" + fileName;

		System.out.println("fileName=" + fileName);
		System.out.println("path=" + path);

		Picture picture = uploadAndSaveImg(file, fileName, path, serverFile, updateAdminId);

		product.setMasterPic(picture);
	}

	private String generateFileName() {
		return new Date().getTime() + ".jpg";
	}

	private Picture uploadAndSaveImg(MultipartFile file, String fileName, String path, String serverFile, Integer updateAdminId) {
		Picture picture = new Picture();

		try {
			log.info("PICTURE path: {}", path);
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
		picture.setUpdateAdminId(updateAdminId);
		pictureService.save(picture);
		return picture;
	}

}
