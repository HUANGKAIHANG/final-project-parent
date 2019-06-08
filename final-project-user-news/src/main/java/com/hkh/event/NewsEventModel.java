package com.hkh.event;

import com.hkh.model.Admin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author HUANG Kaihang
 * @create 2019/6/8 20:56
 * @update 2019/6/8 20:56
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsEventModel {

	private Integer id;

	private String title;

	private String content;

	private Date createTime;

	private Admin inputUser;

	private String operation;
}
