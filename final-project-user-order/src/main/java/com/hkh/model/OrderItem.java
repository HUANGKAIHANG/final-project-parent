package com.hkh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author HUANG Kaihang
 * @create 2019/6/13 14:44
 * @update 2019/6/13 14:44
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_orderitem")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Transient
	private Product product;

	private Integer productId;

	@ManyToOne
	@JoinColumn(name="order_id")
	@JsonIgnore
	private Order order;

	private Integer quantity;
}
