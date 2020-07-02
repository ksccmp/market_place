package com.ssafy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.model.dto.UserInfo;
import com.ssafy.model.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	// 화면을 연결해보세요. (get: /login)
	@GetMapping("/login")
	public String getLogin() {
		return "user/login";
	}
	
	// 파라미터를 Model에 연결해보세요. (post: /login) id: hong, pass: 1234 성공
	@PostMapping("/login")
	public String postLogin(UserInfo user, Model model, HttpSession session) {
		UserInfo selected = service.login(user);
		if(selected != null) {
			session.setAttribute("loginUser", selected);
			return "redirect:main";
		} else {
			model.addAttribute("message", "로그인 실패");
			return "user/login";
		}
	}
	
	@GetMapping("/main")
	public String getMain() {
		return "main";
	}
}
