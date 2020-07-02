package com.ssafy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.model.dto.User;

@Controller
public class LoginController {
	@GetMapping("/login_2")
	public String getlogin() {
		return "login_2";
	}
	
	@PostMapping("/login_2")
	public String postlogin(String id, String password, Model model) {
		if(id.equals("hong") && password.equals("1234")) {
			model.addAttribute("message", "로그인 성공");
			return "showMessage";
		} else {
			model.addAttribute("error", "에러가 발생했습니다.");
			model.addAttribute("myid", id);
			return "login_2";
		}
	}
	
	@PostMapping("/loginByDto")
	public String loginByDTO(User user, Model model, HttpSession session) {
		if(user.getUserid().equals("hong") && user.getPass().equals("1234")) {
			session.setAttribute("message", "로그인 성공");
			return "redirect:showMessage";
		} else {
			model.addAttribute("error", "에러가 발생했습니다.");
			model.addAttribute("myid", user.getUserid());
			return "login_2";
		}
	}
	
	@GetMapping("/showMessage")
	public String showMessage() {
		return "showMessage";
	}
}
