package com.ssafy.model.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
	public String sayHello(String name) {
		return "Hello " + name;
	}
	
	public int calc(int num1, int num2) {
		return num1+num2;
	}
}
