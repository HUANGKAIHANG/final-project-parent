package com.hkh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author HUANG Kaihang
 * @create 2019/6/9 17:23
 * @update 2019/6/9 17:23
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String title;

	private Integer point;

	private Picture masterPic;

	private List<Picture> slavePic;

	private String note;

	private Date createTime;

	private String code;

	private String model;

	private Long stock;

	private Admin inputUser;

	private Integer masterPicId;
}
