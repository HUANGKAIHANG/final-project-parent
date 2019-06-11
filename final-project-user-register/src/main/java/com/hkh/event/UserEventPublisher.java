package com.hkh.event;

import com.hkh.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @author HUANG Kaihang
 * @create 2019/6/11 20:07
 * @update 2019/6/11 20:07
 */

@Slf4j
@EnableBinding(UserEventSource.class)
public class UserEventPublisher {

	@Autowired
	private UserEventSource source;

	public void publish(User user) {
		UserEventModel model = UserEventModel.builder()
				.username(user.getUsername())
				.password(user.getPassword())
				.build();
		log.info("\nPUBLISHING user event {}", model);
		source.output().send(MessageBuilder.withPayload(model).build());
	}
}
