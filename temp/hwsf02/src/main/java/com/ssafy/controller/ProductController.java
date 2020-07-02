package com.ssafy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.model.dto.Product;
import com.ssafy.model.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService service;
	
	@GetMapping("/regist")
	public String getRegist() {
		return "product/regist";
	}
	
	@PostMapping("/product/regist")
	public String postRegist(Product product, Model model) {
		service.insert(product);
		model.addAttribute("message", "등록에 성공했습니다.");
		
		return "redirect:productlist";
	}
	
	@GetMapping("/product/productlist")
	public String getProductList() {
		return "product/productlist";
	}
}
