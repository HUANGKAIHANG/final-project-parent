package com.hkh.service;

import com.hkh.common.Page;
import com.hkh.model.News;
import com.hkh.repository.NewsRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HUANG Kaihang
 * @create 2019/6/9 14:10
 * @update 2019/6/9 14:10
 */

@Service
@Transactional
public class NewsService {

	@Autowired
	NewsRepository newsDao;

	public void addNews(News news) {
		newsDao.save(news);
	}

	public void delNews(Integer newsId) {
		newsDao.deleteById(newsId);
	}

	@HystrixCommand(
			fallbackMethod = "buildFallbackNewsPage",
			threadPoolKey = "newsServiceFindNewsThreadPool",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds"
							, value = "1000")
			}
	)
	public List<News> findNews(Page<News> page) {
		page.setResult(newsDao.findAll(page.getPageable()).getContent());
		page.setTotalCount(newsDao.count());
		return page.getResult();
	}

	@HystrixCommand(
			fallbackMethod = "buildFallbackNews",
			threadPoolKey = "newsServiceFindByIdThreadPool",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds"
							, value = "1000")
			}
	)
	public News findById(Integer id) {
		return newsDao.getOne(id);
	}

	private News buildFallbackNews(Integer id) {
		News news = News.builder()
				.id(id)
				.title("Sorry no News information currently available.")
				.build();
		return news;
	}

	private List<News> buildFallbackNewsPage(Page<News> page) {
		List<News> list = new ArrayList<>();
		News news = News.builder()
				.title("Sorry no News information currently available.")
				.build();
		list.add(news);
		page.setResult(list);
		page.setTotalCount(1);
		return list;
	}
}
