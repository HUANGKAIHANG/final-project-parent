package com.hkh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author HUANG Kaihang
 * @create 2019/6/14 17:07
 * @update 2019/6/14 17:07
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
}
