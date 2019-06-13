package com.hkh.client;

import com.hkh.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author HUANG Kaihang
 * @create 2019/6/13 17:15
 * @update 2019/6/13 17:15
 */

@FeignClient("userproductservice")
public interface ProductFeignClient {

	@RequestMapping(
			method = RequestMethod.GET,
			value = "/product/{id}",
			consumes = "application/json"
	)
	Product getOne(@PathVariable("id") Integer id);
}
