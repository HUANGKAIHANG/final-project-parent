package com.hkh.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HUANG Kaihang
 * @create 2019/6/6 17:17
 * @update 2019/6/6 17:17
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminEventModel {

	private String username;

	private String password;
}
