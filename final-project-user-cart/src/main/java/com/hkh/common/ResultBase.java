package com.hkh.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author HUANG Kaihang
 * @create 2019/6/12 20:23
 * @update 2019/6/12 20:23
 */

@Data
public class ResultBase implements Serializable {

	private Status status;

	private String message;

	public void setToFail() {
		this.message = "未知异常";
		this.status = Status.FAIL;
	}

	public void setToFail(String message) {
		this.message = message;
		this.status = Status.FAIL;
	}

	public void setToSuccess() {
		this.message = "成功";
		this.status = Status.SUCCESS;
	}

	public void setToSuccess(String message) {
		this.message = message;
		this.status = Status.SUCCESS;
	}

	/*@Override
	public String toString() {
		return ToString.toString(this);
	}*/
}

