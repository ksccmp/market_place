package com.ssafy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.model.service.HelloService;

@Controller
public class HelloController {
	@Autowired
	HelloService service;
	
	// Front Controller에서 개별 sub controller 역할 수행
	// client request -> 분석 -> service -> view
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String sayHello(String name, Model model) {
		String message = service.sayHello(name);  // 모델(Service 연동)
		model.addAttribute("message", message); // 뷰를 위한 데이터 저장
		return "showMessage"; // 논리적 뷰 이름 전달
	}
}
