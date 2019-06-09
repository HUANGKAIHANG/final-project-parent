package com.hkh.event;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author HUANG Kaihang
 * @create 2019/6/9 21:06
 * @update 2019/6/9 21:06
 */

public interface ProductEventSink {

	@Input("productEventInput")
	SubscribableChannel input();
}
