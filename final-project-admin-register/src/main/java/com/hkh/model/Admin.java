package com.hkh.model;

import lombok.*;

import java.io.Serializable;

/**
 * @author HUANG Kaihang
 * @create 2019/6/4 21:06
 * @update 2019/6/4 21:06
 */

@Data
@NoArgsConstructor
public class Admin implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String username;

	private String password;
}
