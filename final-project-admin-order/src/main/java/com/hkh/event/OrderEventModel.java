package com.hkh.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HUANG Kaihang
 * @create 2019/6/14 16:17
 * @update 2019/6/14 16:17
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderEventModel {

	private Integer id;

	private String operation;
}
