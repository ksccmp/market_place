package com.ssafy.pms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.pms.Phone;
import com.ssafy.pms.Userinfo;
import com.ssafy.pms.service.IPhoneService;

@Controller
public class MainController {
	private static Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	IPhoneService service;
	
	@GetMapping(value= {"regPhone.do", "pms/PhoneReg"})
	public String getRegForm() {
		return "pms/PhoneReg";
	}
	
	@GetMapping("login.do")
	public String getLoginForm() {
		return "Login";
	}
	
	@PostMapping("login.do")
	public String doLogin(Userinfo user, HttpSession session, Model model) {
		try {
			Userinfo selected = service.selectUser(user);
			if(selected != null) {
				session.setAttribute("loginUser", selected);
				return "redirect:pms/PhoneReg";
			} else {
				return "Login";
			}
		} catch(RuntimeException e) {
			model.addAttribute("title", "로그인 오류");
			model.addAttribute("message", "문제 내용: 로그인 과정에서 오류");
			return "Error";
		}
	}
	
	@GetMapping("logout.do")
	public String doLogout(HttpSession session) {
		session.invalidate();
		return "Login";
	}
	
	@PostMapping("savePhone.do")
	public String doSave(Phone phone, Model model) {
		try {
			service.insert(phone);
			model.addAttribute("title", "핸드폰 관리-등록 성공");
			return "result";
		} catch(RuntimeException e) {
			logger.error("저장실패", e);
			model.addAttribute("title", "핸드폰 관리-등록 실패");
			model.addAttribute("message", "문제 내용-저장 중 오류가 발생");
			return "Error";
		}
	}
	
	@GetMapping("searchPhone.do")
	public String doList(Model model) {
		try {
			List<Phone> phones = service.select();
			model.addAttribute("phones", phones);
			model.addAttribute("title", "핸드폰 관리-조회 성공");
			return "phonelist";
		} catch(RuntimeException e) {
			logger.error("조회실패", e);
			model.addAttribute("title", "핸드폰 관리-조회 실패");
			model.addAttribute("message", "문제 내용-조회 중 오류가 발생");
			return "Error";
		}
	}
	
	@GetMapping("view.do")
	public String doView(Phone phone, Model model) {
		try {
			Phone selected = service.select(phone);
			model.addAttribute("phone", selected);
			model.addAttribute("title", "핸드폰 관리-조회 성공");
			return "phoneview";
		} catch(RuntimeException e) {
			logger.error("조회실패", e);
			model.addAttribute("title", "핸드폰 관리-조회 실패");
			model.addAttribute("message", "문제 내용-조회 중 오류가 발생");
			return "Error";
		}
	}
	
	@GetMapping("delPhone.do")
	public String doDelete(@RequestParam List<String> num, Model model) {
		try {
			service.delete(num);
			return "redirect:searchPhone.do";
		} catch(RuntimeException e) {
			logger.error("삭제실패", e);
			model.addAttribute("title", "핸드폰 관리-삭제 실패");
			model.addAttribute("message", "문제 내용-삭제 중 오류가 발생");
			return "Error";
		}
	}
	
	@GetMapping("rest.do")
	public String getRestForm() {
		return "restclient";
	}
}