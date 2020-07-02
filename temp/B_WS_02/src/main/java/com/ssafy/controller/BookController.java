package com.ssafy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.model.dto.Book;
import com.ssafy.model.service.BookService;

@Controller
public class BookController {
	@Autowired
	BookService service;
	
	@GetMapping("/book/regist")
	public String getRegist() {
		return "book/regist";
	}
	
	@PostMapping("/book/regist")
	public String postRegist(Book book, Model model) {
		int result = service.insert(book);
		
		if(result == 1) {
			model.addAttribute("message", "등록에 성공했습니다.");
		} else {
			model.addAttribute("message", "등록에 실패했습니다.");
		}
		return "result";
	}
}
