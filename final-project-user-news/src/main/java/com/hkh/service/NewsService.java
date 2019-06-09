package com.hkh.service;

import com.hkh.common.Page;
import com.hkh.model.News;
import com.hkh.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	public List<News> findNews(Page<News> page) {
		page.setResult(newsDao.findAll(page.getPageable()).getContent());
		page.setTotalCount(newsDao.count());
		return page.getResult();
	}

	public News findById(Integer id) {
		return newsDao.getOne(id);
	}
}
