package com.hkh.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author HUANG Kaihang
 * @create 2019/6/5 16:55
 * @update 2019/6/5 16:55
 */

@Data
public class ResultBase implements Serializable {

	private Status status;

	private String message;

	public void setToFail() {
		this.message = "unknown error";
		this.status = Status.FAIL;
	}

	public void setToFail(String message) {
		this.message = message;
		this.status = Status.FAIL;
	}

	public void setToSuccess() {
		this.message = "success";
		this.status = Status.SUCCESS;
	}

	public void setToSuccess(String message) {
		this.message = message;
		this.status = Status.SUCCESS;
	}
}