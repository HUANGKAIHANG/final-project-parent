package com.hkh.service;

import com.hkh.model.User;
import com.hkh.model.UserAddress;
import com.hkh.repository.UserAddressRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

	@HystrixCommand(
			fallbackMethod = "buildFallbackUserAddressList",
			threadPoolKey = "userAddressServiceFindByUserIdThreadPool",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds"
							, value = "1000")
			}
	)
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

	@HystrixCommand(
			fallbackMethod = "buildFallbackUserAddress",
			threadPoolKey = "userAddressServiceFindByIdThreadPool",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds"
							, value = "1000")
			}
	)
	public UserAddress findById(Integer id) {
		return userAddressDao.getOne(id);
	}

	public void deleteById(Integer id) {
		userAddressDao.deleteById(id);
	}

	private UserAddress buildFallbackUserAddress(Integer id) {
		UserAddress userAddress = UserAddress.builder()
				.id(id)
				.address("Sorry no UserAddress information currently available.")
				.build();
		return userAddress;
	}

	private List<UserAddress> buildFallbackUserAddressList(Integer userId) {
		List<UserAddress> list = new ArrayList<>();
		UserAddress userAddress = UserAddress.builder()
				.userId(userId)
				.address("Sorry no UserAddress information currently available.")
				.build();
		list.add(userAddress);
		return list;
	}
}
