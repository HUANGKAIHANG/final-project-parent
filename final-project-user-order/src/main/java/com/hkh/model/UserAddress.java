package com.hkh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author HUANG Kaihang
 * @create 2019/6/13 15:11
 * @update 2019/6/13 15:11
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAddress implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String address;

	private String phone;

	private String zipcode;

	private String consignee;

//	private User user;

	private Integer userId;
}
