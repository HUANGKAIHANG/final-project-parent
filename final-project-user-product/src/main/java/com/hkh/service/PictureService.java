package com.hkh.service;

import com.hkh.model.Picture;
import com.hkh.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author HUANG Kaihang
 * @create 2019/6/9 21:39
 * @update 2019/6/11 15:01
 */

@Service
@Transactional
public class PictureService {

	@Autowired
	PictureRepository pictureDao;

	public void save(Picture picture) {
		pictureDao.save(picture);
	}

	public Picture findById(Integer id){
		return pictureDao.getOne(id);
	}
}
