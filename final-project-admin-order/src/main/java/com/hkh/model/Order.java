package com.hkh.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author HUANG Kaihang
 * @create 2019/6/14 15:33
 * @update 2019/6/14 15:33
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String orderNumber;

//	private User user;

	private Integer userId;

	private String address;

	private String phone;

	private String zipcode;

	private String consignee;

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
