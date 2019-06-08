package com.hkh.controller;

import com.hkh.model.News;
import com.hkh.service.NewsService;
import com.hkh.util.AdminUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author HUANG Kaihang
 * @create 2019/6/8 16:37
 * @update 2019/6/8 16:37
 */

@RestController
@RequestMapping("/admin")
@Slf4j
public class NewsAdminController {

	@Autowired
	NewsService newsService;

	@RequestMapping(value = "/news/add", method = RequestMethod.POST)
	public String newsAdd(News news, HttpSession session) {
		System.out.println(AdminUtil.getAdminFromSession(session));
		log.info("ADMIN {} via session {}",AdminUtil.getAdminFromSession(session),session.getId());
		news.setInputUser(AdminUtil.getAdminFromSession(session));
		news.setCreateTime(new Date());
		log.info("NEWS {}",news);
//		newsService.addNews(news);
		return "newsAdd";
	}
}
