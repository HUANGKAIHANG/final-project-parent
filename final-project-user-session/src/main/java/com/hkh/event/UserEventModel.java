package com.hkh.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HUANG Kaihang
 * @create 2019/6/11 21:00
 * @update 2019/6/11 21:00
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEventModel {

	private String username;

	private String password;
}
