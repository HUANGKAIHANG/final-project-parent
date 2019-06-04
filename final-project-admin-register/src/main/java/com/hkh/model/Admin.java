package com.hkh.model;

import lombok.*;

import java.io.Serializable;

/**
 * @author HUANG Kaihang
 * @create 2019/6/4 21:06
 * @update 2019/6/4 21:06
 */

@Data
public class Admin implements Serializable {

	private Integer id;

	private String username;

	private String password;
}
