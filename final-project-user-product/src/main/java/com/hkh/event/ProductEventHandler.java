package com.hkh.event;

import com.hkh.common.Constants;
import com.hkh.model.Picture;
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
 * @update 2019/6/11 15:58
 */

@EnableBinding(ProductEventSink.class)
@Slf4j
public class ProductEventHandler {

	@Autowired
	private ProductService productService;

	@Autowired
	private PictureService pictureService;

	private static final String PRODUCT_ADD = Constants.PRODUCT_ADD;

	private static final String PRODUCT_EDIT = Constants.PRODUCT_EDIT;

	@StreamListener("productEventInput")
	public void handle(ProductEventModel model) {
		log.info("\nRECEIVED product {}", model);
		if (PRODUCT_ADD.equals(model.getOperation())) {
			Picture tempPicture = model.getMasterPic();
			Picture picture = buildNewPictureModel(tempPicture, model.getInputUser().getId());
			addPicture(picture);
			Product product = Product.builder()
					.code(model.getCode())
					.createTime(model.getCreateTime())
					.model(model.getModel())
					.note(model.getNote())
					.point(model.getPoint())
					.stock(model.getStock())
					.title(model.getTitle())
					.inputUserId(model.getInputUser().getId())
					.masterPic(picture)
					.build();
			addProduct(product);
		} else if (PRODUCT_EDIT.equals(model.getOperation()) && model.getEditWithNewImageFile()) {
			Picture tempPicture = model.getMasterPic();
			Picture masterPic = buildNewPictureModel(tempPicture, model.getInputUser().getId());
			addPicture(masterPic);
			Product product = buildEditProductModel(model, masterPic);
			addProduct(product);
		} else if (PRODUCT_EDIT.equals(model.getOperation()) && !model.getEditWithNewImageFile()) {
			Picture masterPic = findPictureById(model.getMasterPic().getId());
			Product product = buildEditProductModel(model, masterPic);
			addProduct(product);
		}
	}

	public void addProduct(Product product) {
		productService.save(product);
	}

	public void addPicture(Picture picture) {
		pictureService.save(picture);
	}

	public Picture findPictureById(Integer id) {
		return pictureService.findById(id);
	}

	public Picture buildNewPictureModel(Picture tempPicture, Integer updateAdminId) {
		Picture picture = Picture.builder()
				.title(tempPicture.getTitle())
				.memo(tempPicture.getMemo())
				.url(tempPicture.getUrl())
				.updateTime(tempPicture.getUpdateTime())
				.updateAdminId(updateAdminId)
				.build();
		return picture;
	}

	public Product buildEditProductModel(ProductEventModel model, Picture masterPic) {
		Product product = Product.builder()
				.id(model.getId())
				.code(model.getCode())
				.createTime(model.getCreateTime())
				.model(model.getModel())
				.note(model.getNote())
				.point(model.getPoint())
				.stock(model.getStock())
				.title(model.getTitle())
				.inputUserId(model.getInputUser().getId())
				.masterPic(masterPic)
				.build();
		return product;
	}

}
