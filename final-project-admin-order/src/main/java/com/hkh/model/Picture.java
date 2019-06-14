package com.hkh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author HUANG Kaihang
 * @create 2019/6/14 15:47
 * @update 2019/6/14 15:47
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Picture implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String title;

	private String memo;

	private String url;

	private Date updateTime;

	private Integer updateAdminId;

}
