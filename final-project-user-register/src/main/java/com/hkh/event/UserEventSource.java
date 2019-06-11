package com.hkh.event;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author HUANG Kaihang
 * @create 2019/6/11 20:06
 * @update 2019/6/11 20:06
 */

public interface UserEventSource {

	@Output("userEventOutput")
	MessageChannel output();
}
