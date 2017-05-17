package com.geek.utils;

public class ErrorMessageModel {
	private String field;
	private String msg;
	
	public ErrorMessageModel() {
	}
	public ErrorMessageModel(String field, String msg) {
		this.field = field;
		this.msg = msg;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
