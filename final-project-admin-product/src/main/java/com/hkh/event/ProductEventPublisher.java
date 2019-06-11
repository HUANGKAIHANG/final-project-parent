package com.hkh.event;

import com.hkh.common.Constants;
import com.hkh.model.Picture;
import com.hkh.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @author HUANG Kaihang
 * @create 2019/6/9 20:29
 * @update 2019/6/10 16:46
 */

@Slf4j
@EnableBinding(ProductEventSource.class)
public class ProductEventPublisher {

	@Autowired
	private ProductEventSource source;

	public void publish(Product product) {
		ProductEventModel model = ProductEventModel.builder()
				.code(product.getCode())
				.createTime(product.getCreateTime())
				.model(product.getModel())
				.note(product.getNote())
				.point(product.getPoint())
				.stock(product.getStock())
				.title(product.getTitle())
				.inputUser(product.getInputUser())
				.masterPic(product.getMasterPic())
				.operation(Constants.PRODUCT_ADD)
				.build();
		log.info("\nPICTURE url {}", model.getMasterPic().getUrl());
		log.info("\nPUBLISHING product event {}", model);
		source.output().send(MessageBuilder.withPayload(model).build());
	}

	public void publishEdit(Product product, boolean fileRequired) {
		ProductEventModel model = ProductEventModel.builder()
				.id(product.getId())
				.code(product.getCode())
				.model(product.getModel())
				.note(product.getNote())
				.point(product.getPoint())
				.stock(product.getStock())
				.title(product.getTitle())
				.createTime(product.getCreateTime())
				.inputUser(product.getInputUser())
				.operation(Constants.PRODUCT_EDIT)
				.editWithNewImageFile(fileRequired)
				.build();
		if (fileRequired) {
			model.setMasterPic(product.getMasterPic());
		} else {
			Picture picture = new Picture();
			picture.setId(product.getMasterPicId());
			model.setMasterPic(picture);
		}
		log.info("\nFILE required {}", fileRequired);
		log.info("\nPUBLISHING product edit event {}", model);
		source.output().send(MessageBuilder.withPayload(model).build());
	}
}
