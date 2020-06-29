package market.place.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import market.place.dto.Product;
import market.place.dto.User;
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
	public String postRegisterProduct(Product product, HttpSession session, Model model) {
		User user = (User)(session.getAttribute("user"));
		product.setUserid(user.getUserid());
		
		model.addAttribute("result", pServ.insert(product));
		model.addAttribute("successMessage", "물품을 등록했습니다.");
		model.addAttribute("failMessage", "물품등록에 실패했습니다.");
		model.addAttribute("nextUrl", "/market-place/productList");
		return "registerProductRes";
	}
}
