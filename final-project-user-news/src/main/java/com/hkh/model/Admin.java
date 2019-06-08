package com.hkh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author HUANG Kaihang
 * @create 2019/6/8 20:52
 * @update 2019/6/8 20:52
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String username;

	private String password;
}
