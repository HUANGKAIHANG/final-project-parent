package com.hkh.service;

import com.hkh.model.User;
import com.hkh.model.UserAddress;
import com.hkh.repository.UserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author HUANG Kaihang
 * @create 2019/6/12 15:58
 * @update 2019/6/12 15:58
 */

@Service
@Transactional
public class UserAddressService {

	@Autowired
	private UserAddressRepository userAddressDao;

	public List<UserAddress> findByUserId(Integer userId) {
		/*User user = new User();
		user.setId(userId);*/
		return userAddressDao.findByUserId(userId);
	}

	public void save(UserAddress userAddress) {
		userAddressDao.save(userAddress);
	}

	public void updateUserAddress(UserAddress userAddress) {
		userAddressDao.save(userAddress);
	}

	public UserAddress findById(Integer id) {
		return userAddressDao.getOne(id);
	}

	public void deleteById(Integer id) {
		userAddressDao.deleteById(id);
	}
}
