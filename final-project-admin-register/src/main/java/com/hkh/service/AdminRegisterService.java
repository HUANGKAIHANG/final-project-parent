package com.hkh.service;

import com.hkh.event.AdminEventPublisher;
import com.hkh.model.Admin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HUANG Kaihang
 * @create 2019/6/4 21:06
 * @update 2019/6/6 16:30
 */

@Service
@Slf4j
public class AdminRegisterService {

	@Autowired
	private AdminEventPublisher adminEventPublisher;

	public void publishAdmin(Admin admin) {
		adminEventPublisher.publish(admin);
	}
}
