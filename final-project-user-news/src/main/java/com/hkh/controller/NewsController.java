package com.hkh.controller;

import com.hkh.common.Page;
import com.hkh.model.News;
import com.hkh.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author HUANG Kaihang
 * @create 2019/6/9 14:09
 * @update 2019/6/9 14:09
 */

@RestController
@RequestMapping("/news")
public class NewsController {

	@Autowired
	NewsService newsService;

	@RequestMapping(method = RequestMethod.GET)
	public Page<News> index(HttpServletRequest request) {
		Page<News> page = new Page<>(request);
		newsService.findNews(page);
		return page;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public News viewNews(@PathVariable Integer id) {
		return newsService.findById(id);
	}
}
