package com.hkh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author HUANG Kaihang
 * @create 2019/6/14 17:07
 * @update 2019/6/14 17:07
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

	private Integer inputUserId;

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", title='" + title + '\'' +
				", point=" + point +
				", masterPic=" + masterPic +
				", slavePic=" + slavePic +
				", note='" + note + '\'' +
				", createTime=" + createTime +
				", code='" + code + '\'' +
				", model='" + model + '\'' +
				", stock=" + stock +
				", inputUserId=" + inputUserId +
				'}';
	}
}
