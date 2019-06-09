package com.hkh.service;

import com.hkh.event.NewsEventPublisher;
import com.hkh.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HUANG Kaihang
 * @create 2019/6/8 16:42
 * @update 2019/6/8 16:42
 */

@Service
public class NewsService {

	@Autowired
	private NewsEventPublisher newsEventPublisher;

	public void addNews(News news) {
		newsEventPublisher.publish(news);
	}

	public void delNews(Integer newsId) {
		newsEventPublisher.publishDelete(newsId);
	}

}
