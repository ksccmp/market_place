package com.ssafy.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.model.service.HelloService;

@Controller
// @RequestMapping("/user") => 클래스 레벨 사용: 모든 mapping에 영향
public class MyController {
	@Autowired
	HelloService service;
	
	@GetMapping("/calc")
	public String getCalcForm() {
		return "simple/calc";
	}
	
	@PostMapping("/calc")
	public String calc(int num1, int num2, Model model) {
		int result = service.calc(num1, num2);
		model.addAttribute("result", result);
		return "simple/calcResult";
	}
	
	@GetMapping("/user/{id}") // user/hong
	public String restAPI(@PathVariable String id, Model model) {
		model.addAttribute("message", id);
		return "showMessage";
	}
	
	@GetMapping("/cookieMaker")
	public String cookieMaker(HttpServletResponse res, Model model) {
		Cookie cookie = new Cookie("name", "홍길동");
		cookie.setMaxAge(60 * 3);
		res.addCookie(cookie);
		model.addAttribute("message", "cookie 생성 완료");
		
		return "showMessage";
	}
	
	@GetMapping("/cookieConsumer")
	public String cookieConsumer(@CookieValue String name, Model model) {
		model.addAttribute("message", "쿠키 확인 " + name);
		return "showMessage";
	}
}
