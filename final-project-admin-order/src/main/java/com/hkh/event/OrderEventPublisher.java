package com.hkh.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @author HUANG Kaihang
 * @create 2019/6/14 16:20
 * @update 2019/6/14 16:20
 */

@Slf4j
@EnableBinding(OrderEventSource.class)
public class OrderEventPublisher {

	@Autowired
	private OrderEventSource source;

	public void publish(Integer orderId, String operation) {
		OrderEventModel model = OrderEventModel.builder()
				.id(orderId)
				.operation(operation)
				.build();
		log.info("\nPUBLISHING order event {}", model);
		source.output().send(MessageBuilder.withPayload(model).build());
	}
}
