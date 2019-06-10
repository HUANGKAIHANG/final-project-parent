package com.hkh.event;

import com.hkh.common.Constants;
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
		log.info("PICTURE url {}", model.getMasterPic().getUrl());
		log.info("PUBLISHING product event {}", model);
		source.output().send(MessageBuilder.withPayload(model).build());
	}

	/*public void publishDelete(Integer newsId) {
		NewsEventModel model = NewsEventModel.builder()
				.id(newsId)
				.operation(Constants.NEWS_DELETE)
				.build();
		log.info("PUBLISHING news event {}", model);
		source.output().send(MessageBuilder.withPayload(model).build());
	}*/
}
