package com.LearningSpring.LearnSpring.controller;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

//Component tag is added to work with autowired, if component is not added in the bean class then autowired will not work
@Component
public class ReturnResponse {
	
	private String msg;
	private String id;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
