package com.hkh.service;

import com.hkh.model.Admin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author HUANG Kaihang
 * @create 2019/6/4 21:06
 * @update 2019/6/4 21:06
 */

@Service
@Slf4j
public class AdminRegisterService {

	public void publishAdmin(Admin admin) {
		log.info("PUBLISH admin account {}", admin);
	}
}
