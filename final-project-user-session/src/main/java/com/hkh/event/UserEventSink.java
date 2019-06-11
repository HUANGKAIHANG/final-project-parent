package com.hkh.event;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author HUANG Kaihang
 * @create 2019/6/11 21:01
 * @update 2019/6/11 21:01
 */

public interface UserEventSink {

	@Input("userEventInput")
	SubscribableChannel input();
}

