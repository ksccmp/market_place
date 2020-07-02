package com.ssafy.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.todo.dto.Todo;

@Controller
public class MyController {
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("message", "Hello MVC");
		return "showMessage";
	}
	
	@GetMapping("/rest")
	@ResponseBody
	public String rest() {
		return "Hello Rest";
	}
	
	@GetMapping("/todo")
	@ResponseBody
	public Todo restTodo() {
		return new Todo(1, "spring 공부하기");
	}
}
