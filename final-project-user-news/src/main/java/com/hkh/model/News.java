package com.hkh.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author HUANG Kaihang
 * @create 2019/6/8 20:52
 * @update 2019/6/8 20:52
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_news")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class News implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String title;

	private String content;

	private Date createTime;

//	private Admin inputUser;

	private Integer inputUserId;
}
