package com.hkh.event;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author HUANG Kaihang
 * @create 2019/6/6 17:21
 * @update 2019/6/6 17:21
 */

public interface AdminEventSink {

	@Input("adminEventInput")
	SubscribableChannel input();
}
