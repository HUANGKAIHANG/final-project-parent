package com.hkh.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author HUANG Kaihang
 * @create 2019/6/9 20:55
 * @update 2019/6/11 15:15
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_product")
@DynamicUpdate
@Proxy(lazy = false)
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String title;

	private Integer point;

	@ManyToOne/*(cascade = {CascadeType.ALL})*/
	@JoinColumn
	private Picture masterPic;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Picture> slavePic;

	@Lob
	@Column(columnDefinition = "TEXT")
	private String note;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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

