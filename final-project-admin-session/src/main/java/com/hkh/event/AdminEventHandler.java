package com.hkh.event;

import com.hkh.model.Admin;
import com.hkh.repository.AdminRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @author HUANG Kaihang
 * @create 2019/6/6 17:23
 * @update 2019/6/6 17:23
 */

@EnableBinding(AdminEventSink.class)
@Slf4j
public class AdminEventHandler {

	@Autowired
	private AdminRepository adminRepository;

	@StreamListener("adminEventInput")
	public void handle(AdminEventModel model) {
		log.info("RECEIVED admin {}", model);
		Admin admin = Admin.builder()
				.username(model.getUsername())
				.password(model.getPassword())
				.build();
		adminRepository.save(admin);
	}
}
