package com.shuahuo.util;

import java.util.List;

public class JsonUtil<T> {
	private int code; // 0：成功，-1：失败
	private String msg;
	private int count;
	private List<T> data;
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	//改
	public JsonUtil addMsg(String msg){
		this.setMsg(msg);
		return this;
	}
	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public JsonUtil addCount(int value) {
		this.setCount(value);
		return this;
	}
	
	public JsonUtil addData(List<T> data) {
		this.setData(data);
		return this;
	}
	
	public static JsonUtil success() {
		JsonUtil jsonUtil = new JsonUtil();
		jsonUtil.setCode(0);
		jsonUtil.setMsg("处理成功");
		return jsonUtil;
	}
	
	//改
	public static JsonUtil fail(String Reason) {
		JsonUtil jsonUtil = new JsonUtil();
		jsonUtil.setCode(-1);
		jsonUtil.setMsg(Reason);
		return jsonUtil;
	}
}