package com.hkh.event;

import com.hkh.model.Admin;
import com.hkh.model.Picture;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * @author HUANG Kaihang
 * @create 2019/6/9 21:05
 * @update 2019/6/9 21:05
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEventModel {

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

	private MultipartFile file;

	private String filePath;

	private String operation;
}
