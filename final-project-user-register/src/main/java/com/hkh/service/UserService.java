package com.hkh.service;

import com.hkh.event.UserEventPublisher;
import com.hkh.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HUANG Kaihang
 * @create 2019/6/11 20:13
 * @update 2019/6/11 20:13
 */

@Service
public class UserService {

	@Autowired
	private UserEventPublisher userEventPublisher;

	public void save(User user) {
		userEventPublisher.publish(user);
	}
}
