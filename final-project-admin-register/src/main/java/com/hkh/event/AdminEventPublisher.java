package com.hkh.event;

import com.hkh.model.Admin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @author HUANG Kaihang
 * @create 2019/6/6 16:25
 * @update 2019/6/6 16:25
 */

@Slf4j
@EnableBinding(AdminEventSource.class)
public class AdminEventPublisher {

	@Autowired
	private AdminEventSource source;

	public void publish(Admin admin) {
		AdminEventModel model = AdminEventModel.builder()
				.username(admin.getUsername())
				.password(admin.getPassword())
				.build();
		log.info("\nPUBLISHING admin event {}", model);
		source.output().send(MessageBuilder.withPayload(model).build());
	}
}
