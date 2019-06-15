package com.hkh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author HUANG Kaihang
 * @create 2019/6/13 14:41
 * @update 2019/6/13 14:41
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_order")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String orderNumber;

//	private User user;

	private Integer userId;

	private String address;

	private String phone;

	private String zipcode;

	private String consignee;

	@OneToMany(mappedBy = "order")
//	@JsonIgnore
	private List<OrderItem> orderItems;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:SS")
	private Date createTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:SS")
	private Date payTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:SS")
	private Date shipTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:SS")
	private Date confirmTime;

	private Integer status;

	@NumberFormat(pattern = "0.00")
	private Double finalPrice;

	@NumberFormat(pattern = "0.00")
	private Double totalPrice;

}
