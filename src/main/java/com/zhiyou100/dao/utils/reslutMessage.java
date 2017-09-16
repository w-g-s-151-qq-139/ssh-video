package com.zhiyou100.dao.utils;

public class reslutMessage {

	private boolean orsucess;
	private String message;
	public boolean isOrsucess() {
		return orsucess;
	}
	public void setOrsucess(boolean orsucess) {
		this.orsucess = orsucess;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "reslutMessage [orsucess=" + orsucess + ", message=" + message + "]";
	}
	
	
}
