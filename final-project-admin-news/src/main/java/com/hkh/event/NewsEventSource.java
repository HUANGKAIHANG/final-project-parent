package com.hkh.event;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author HUANG Kaihang
 * @create 2019/6/8 16:48
 * @update 2019/6/8 16:48
 */

public interface NewsEventSource {

	@Output("newsEventOutput")
	MessageChannel output();
}
