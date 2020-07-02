package com.ssafy.zoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Zoo {
	private String name;
	private Tiger tiger;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Tiger getTiger() {
		return tiger;
	}
	
	@Autowired
	public void setTiger(Tiger tiger) {
		this.tiger = tiger;
	}
}
