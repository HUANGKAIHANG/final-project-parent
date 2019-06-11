package com.hkh.event;

import com.hkh.common.Constants;
import com.hkh.model.News;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @author HUANG Kaihang
 * @create 2019/6/8 16:49
 * @update 2019/6/8 16:49
 */

@Slf4j
@EnableBinding(NewsEventSource.class)
public class NewsEventPublisher {

	@Autowired
	private NewsEventSource source;

	public void publish(News news) {
		NewsEventModel model = NewsEventModel.builder()
				.title(news.getTitle())
				.content(news.getContent())
				.createTime(news.getCreateTime())
				.inputUser(news.getInputUser())
				.operation(Constants.NEWS_ADD)
				.build();
		log.info("\nPUBLISHING news event {}", model);
		source.output().send(MessageBuilder.withPayload(model).build());
	}

	public void publishDelete(Integer newsId) {
		NewsEventModel model = NewsEventModel.builder()
				.id(newsId)
				.operation(Constants.NEWS_DELETE)
				.build();
		log.info("\nPUBLISHING news event {}", model);
		source.output().send(MessageBuilder.withPayload(model).build());
	}
}
