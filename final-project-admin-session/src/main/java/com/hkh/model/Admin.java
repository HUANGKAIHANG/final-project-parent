package com.hkh.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author HUANG Kaihang
 * @create 2019/6/5 16:52
 * @update 2019/6/6 17:27
 */

@Data
@Entity
@Table(name = "t_admin")
public class Admin implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String username;

	private String password;
}
