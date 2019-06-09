package com.hkh.event;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author HUANG Kaihang
 * @create 2019/6/9 20:29
 * @update 2019/6/9 20:29
 */

public interface ProductEventSource {

	@Output("productEventOutput")
	MessageChannel output();
}
