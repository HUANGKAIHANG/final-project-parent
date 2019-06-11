package com.hkh.event;

import com.hkh.model.User;
import com.hkh.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @author HUANG Kaihang
 * @create 2019/6/11 21:02
 * @update 2019/6/11 21:02
 */

@EnableBinding(UserEventSink.class)
@Slf4j
public class UserEventHandler {

	@Autowired
	private UserService userService;

	@StreamListener("userEventInput")
	public void handle(UserEventModel model) {
		log.info("\nRECEIVED user {}", model);
		User user = User.builder()
				.username(model.getUsername())
				.password(model.getPassword())
				.build();
		userService.save(user);
	}
}
