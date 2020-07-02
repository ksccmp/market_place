package com.ssafy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.model.dto.Product;
import com.ssafy.model.service.ProductService;

@Controller
public class ProductController {
	private static Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService service;
	
	@GetMapping("/regist")
	public String getRegist() {
		return "product/regist";
	}
	
	@PostMapping("/product/regist")
	public String postRegist(Product product, RedirectAttributes redir) {
		try {
			service.insert(product);
			redir.addFlashAttribute("message", "상품 등록 성공!");
		} catch(RuntimeException e) {
			logger.error("상품등록 실패");
			redir.addFlashAttribute("message", "상품 등록 실패!");
		}
		return "redirect:productlist";
	}
	
	@GetMapping("/product/productlist")
	public String getProductList(Model model) {
		model.addAttribute("products", service.selectAll());
		return "product/productlist";
	}
}
