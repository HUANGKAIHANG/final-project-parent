package com.hkh.event;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author HUANG Kaihang
 * @create 2019/6/14 16:31
 * @update 2019/6/14 16:31
 */

public interface OrderEventSink {

	@Input("orderEventInput")
	SubscribableChannel input();
}
