package market.place.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
}
