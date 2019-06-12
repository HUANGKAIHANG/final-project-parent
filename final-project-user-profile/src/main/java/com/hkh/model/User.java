package com.hkh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author HUANG Kaihang
 * @create 2019/6/12 15:24
 * @update 2019/6/12 15:24
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String account;

	private String username;

	private Long balance;

	private Long point;

	private String phone;

	private String telPhone;

	private String address;

	private String zipCode;

	private String remark;

	private String password;

	private String slat;

//	private List<UserAddress> addresses;

//	private List<Order> orders;

	/*public User(Integer id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}*/
}
