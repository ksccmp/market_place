package com.ssafy.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.model.dto.User;
import com.ssafy.model.service.UserService;

@Controller
public class UserController {
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService uService;
	
	@GetMapping("/regist")
	public String getRegistForm() {
		return "regist";
	}
	
	@PostMapping("/regist")
	public String doRegist(User user, Model model, RedirectAttributes redir) {
		try {
			uService.join(user);
			redir.addFlashAttribute("message", "회원가입에 성공!");
			// 가입 성공 시 main.jsp로 이동
			return "redirect:main";
		} catch(RuntimeException e) {
			logger.error("회원가입 실패", e);
			model.addAttribute("message", "회원가입 실패!");
			return "showMessage";
		}
	}	
	
	@GetMapping("/login")
	public String getLoginForm() {
		return "login";
	}
	
	@PostMapping("/login")
	public String doLogin(User user, Model model, HttpSession session) {
		User loginUser = uService.login(user);
		if(loginUser == null) {
			model.addAttribute("message", "아이디/비밀번호 확인 필요");
			return "login";
		} else {
			session.setAttribute("loginUser", loginUser);
			return "redirect:main";
		}
	}
	
	@GetMapping("/list")
	public String doList(Model model) {
		model.addAttribute("users", uService.all());
		return "list";
	}
	
	@GetMapping("/detail")
	public String doDetail(String userid, Model model) {
		model.addAttribute("user", uService.detail(userid));
		return "detail";
	}
	
	@PostMapping("/modfiy")
	public String doModify(User user, RedirectAttributes redir) {
		try {
			uService.change(user);
			redir.addFlashAttribute("message", "정보수정에 성공!");
		} catch(RuntimeException e) {
			logger.error("정보수정 실패");
			redir.addFlashAttribute("message", "정보수정에 실패!");
		}
		return "redirect:list";
	}
	
	@PostMapping("/delete")
	public String doDelete(User user, RedirectAttributes redir) {
		try {
			uService.withdraw(user);
			redir.addFlashAttribute("message", "정보삭제에 성공!");
		} catch(RuntimeException e) {
			logger.error("정보삭제 실패");
			redir.addFlashAttribute("message", "정보삭제에 실패!");
		}
		return "redirect:list";
	}
	
	@GetMapping("/multiDelete")
	public String multiDelete(@RequestParam ArrayList<String> target, RedirectAttributes redir) {
		logger.trace("target: {}", target);
		try {
			uService.multiDel(target);
			redir.addFlashAttribute("message", "멀티삭제에 성공!");
		} catch(RuntimeException e) {
			logger.error("멀티삭제 실패");
			redir.addFlashAttribute("message", "멀티삭제에 실패!");
		}
		return "redirect:list";
	}
	
	@GetMapping("/main")
	public String getMainForm() {
		return "main";
	}
}
