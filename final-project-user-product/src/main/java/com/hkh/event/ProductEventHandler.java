package com.hkh.event;

import com.hkh.common.Constants;
import com.hkh.model.Product;
import com.hkh.service.PictureService;
import com.hkh.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @author HUANG Kaihang
 * @create 2019/6/10 16:46
 * @update 2019/6/10 16:46
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

			/*Picture masterPic = model.getMasterPic();
			Picture picture = Picture.builder()
					.memo(masterPic.getMemo())
					.title(masterPic.getTitle())
					.updateTime(masterPic.getUpdateTime())
					.url(masterPic.getUrl())
					.updateAdminId(model.getInputUser().getId())
					.build();
			addPicture(picture);*/

			Product product = Product.builder()
					.code(model.getCode())
					.createTime(model.getCreateTime())
					.model(model.getModel())
					.note(model.getNote())
					.point(model.getPoint())
					.stock(model.getStock())
					.title(model.getTitle())
					.inputUserId(model.getInputUser().getId())
					.masterPic(model.getMasterPic())
					.build();
			addProduct(product);
		} else {

		}
	}

	public void addProduct(Product product) {
		productService.save(product);
	}

	/*public void addPicture(Picture picture){
		pictureService.save(picture);
	}*/

	/*public void delete(Integer id) {
		newsService.delNews(id);
	}*/

}
