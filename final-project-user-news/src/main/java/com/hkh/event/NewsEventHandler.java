package com.hkh.event;

import com.hkh.common.Constants;
import com.hkh.model.News;
import com.hkh.service.NewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @author HUANG Kaihang
 * @create 2019/6/8 20:58
 * @update 2019/6/9 14:42
 */

@EnableBinding(NewsEventSink.class)
@Slf4j
public class NewsEventHandler {

	@Autowired
	private NewsService newsService;

	private static final String NEWS_ADD = Constants.NEWS_ADD;

	@StreamListener("newsEventInput")
	public void handle(NewsEventModel model) {
		log.info("RECEIVED news {}", model);
		if (NEWS_ADD.equals(model.getOperation())) {
			News news = News.builder()
					.title(model.getTitle())
					.content(model.getContent())
					.createTime(model.getCreateTime())
					.inputUserId(model.getInputUser().getId())
					.build();
			add(news);
		} else {
			delete(model.getId());
		}
	}

	public void add(News news) {
		newsService.addNews(news);
	}

	public void delete(Integer id) {
		newsService.delNews(id);
	}
}
