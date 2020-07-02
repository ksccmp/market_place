package market.place.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import market.place.dto.User;
import market.place.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService uServ;
	
	@GetMapping("/signUp")
	public String getSignUp() {
		return "signUp";
	}
	
	@PostMapping("/signUp.do")
	public String postSignUp(User user, Model model) {
		model.addAttribute("signUpRes", uServ.insert(user));
		return "signUpRes";
	}
	
	@PostMapping("/login.do")
	public String postLogin(@RequestParam String userid, @RequestParam String password, HttpSession session) {
		User user = uServ.selectByUserid(userid);
		if(user != null && user.getPassword().equals(password)) {
			session.setAttribute("user", user);
		}
		
		return "loginRes";
	}
	
	@PostMapping("/logout.do")
	public String postLogout(HttpSession session) {
		session.invalidate();
		return "redirect:productList";
	}
}
