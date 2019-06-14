package com.hkh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author HUANG Kaihang
 * @create 2019/6/14 15:45
 * @update 2019/6/14 15:45
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private Product product;

	private Integer productId;

	private Order order;

	private Integer quantity;
}
