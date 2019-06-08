package com.hkh.event;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author HUANG Kaihang
 * @create 2019/6/8 20:56
 * @update 2019/6/8 20:56
 */

public interface NewsEventSink {

	@Input("newsEventInput")
	SubscribableChannel input();
}
