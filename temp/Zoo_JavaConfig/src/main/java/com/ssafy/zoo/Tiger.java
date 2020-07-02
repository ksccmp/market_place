package com.ssafy.zoo;

import org.springframework.stereotype.Component;

@Component
public class Tiger {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("tiger setname: " + name);
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
