package com.hkh.util;

import com.hkh.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author HUANG Kaihang
 * @create 2019/6/12 20:39
 * @update 2019/6/12 20:39
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private Product product;

	private Integer total;

}
