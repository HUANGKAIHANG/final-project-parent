package com.hkh.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author HUANG Kaihang
 * @create 2019/6/11 20:55
 * @update 2019/6/11 20:55
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String account;

	@Length(min = 2, max = 15)
	private String username;

	private Long balance;

	@Max(999999)
	@Min(0)
	private Long point;

	@Length(min = 11, max = 11)
	private String phone;

	@Length(min = 11, max = 11)
	private String telPhone;

	@Length(min = 4, max = 50)
	private String address;

	@Length(min = 6, max = 6)
	private String zipCode;

	@Length(max = 50)
	private String remark;

	@NotEmpty
	@Length(min = 6, max = 14)
	private String password;

	private String slat;

//	private List<UserAddress> addresses;

//	private List<Order> orders;

	/*public User(Integer id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}*/
}
