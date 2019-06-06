package com.hkh.event;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author HUANG Kaihang
 * @create 2019/6/6 16:22
 * @update 2019/6/6 16:22
 */

public interface AdminEventSource {

	@Output("adminEventOutput")
	MessageChannel output();
}
