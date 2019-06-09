package com.hkh.controller;

import com.hkh.common.JsonResult;
import com.hkh.model.News;
import com.hkh.service.NewsService;
import com.hkh.util.AdminUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author HUANG Kaihang
 * @create 2019/6/8 16:37
 * @update 2019/6/9 15:25
 */

@RestController
@RequestMapping("/admin")
public class NewsAdminController {

	@Autowired
	NewsService newsService;

	@RequestMapping(value = "/news/add", method = RequestMethod.POST)
	public String newsAdd(News news, HttpSession session) {
		news.setInputUser(AdminUtil.getAdminFromSession(session));
		news.setCreateTime(new Date());
		newsService.addNews(news);
		return "newsAdd";
	}

	@RequestMapping(value = "/news/delete/{id}")
	@ResponseBody
	public JsonResult newsDelete(@PathVariable("id") Integer id) {
		newsService.delNews(id);
		JsonResult result = new JsonResult();
		result.setToSuccess();
		return result;
	}

}
