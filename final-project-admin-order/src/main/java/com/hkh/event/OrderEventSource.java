package com.hkh.event;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author HUANG Kaihang
 * @create 2019/6/14 16:19
 * @update 2019/6/14 16:19
 */

public interface OrderEventSource {

	@Output("orderEventOutput")
	MessageChannel output();
}
