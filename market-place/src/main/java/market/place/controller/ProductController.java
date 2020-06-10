package market.place.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import market.place.dto.Product;
import market.place.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService pServ;
	
	@GetMapping("/productList")
	public String getProductList(Model model) {
		model.addAttribute("productList", pServ.selectAll());
		return "productList";
	}
	
	@GetMapping("/registerProduct")
	public String getRegisterProduct() {
		return "registerProduct";
	}
	
	@PostMapping("/registerProduct.do")
	public String postRegisterProduct(Product product) {
		return "redirect:productList";
	}
}
