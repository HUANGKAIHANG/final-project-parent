package com.hkh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author HUANG Kaihang
 * @create 2019/6/8 16:25
 * @update 2019/6/8 16:25
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String username;

	private String password;
}
