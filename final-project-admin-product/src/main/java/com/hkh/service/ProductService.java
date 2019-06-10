package com.hkh.service;

import com.hkh.event.ProductEventPublisher;
import com.hkh.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author HUANG Kaihang
 * @create 2019/6/9 20:16
 * @update 2019/6/10 16:47
 */

@Service
//@Transactional
public class ProductService {

	@Autowired
	private ProductEventPublisher productEventPublisher;

	public void save(Product product) {
		productEventPublisher.publish(product);
	}

	/*public void delNews(Integer newsId) {
		newsEventPublisher.publishDelete(newsId);
	}*/
}
