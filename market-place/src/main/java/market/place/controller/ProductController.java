package market.place.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import market.place.dto.Product;
import market.place.dto.Purchase;
import market.place.dto.User;
import market.place.service.ProductService;
import market.place.service.PurchaseService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService pServ;
	
	@Autowired
	PurchaseService puServ;
	
	@GetMapping("/productList")
	public String getProductList(Model model) {
		model.addAttribute("productList", pServ.selectAll());
		return "productList";
	}
	
	@GetMapping("/registerProduct")
	public String getRegisterProduct() {
		return "registerProduct";
	}
	
	@GetMapping("/myProduct")
	public String getMyProduct(Model model, HttpSession session) {
		User user = (User)session.getAttribute("user");
		model.addAttribute("myProducts", puServ.selectByUserid(user.getUserid()));
		return "myProduct";
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
	
	@DeleteMapping("/deleteProduct/{productId}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> deleteProduct(@PathVariable int productId) {
		try {
			Product product = new Product();
			product.setId(productId);
			
			return response(pServ.delete(product), HttpStatus.OK, true);
		} catch(RuntimeException e) {
			return response(e.getMessage(), HttpStatus.CONFLICT, false);
		}
	}
	
	@PutMapping("/purchaseProduct/{productId}/{count}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> purchaseProduct(@PathVariable int productId, @PathVariable int count, HttpSession session) {
		try {
			Product product = pServ.selectById(productId);
			if(product.getCount() < count) {
				return response(product.getCount(), HttpStatus.OK, false);
			} else {
				product.setCount(product.getCount() - count);
				int result = pServ.updateByCount(product);
				
				if(result == 1) {
					User user = (User)session.getAttribute("user");
					Purchase purchase = new Purchase(0, user.getUserid(), productId, count, null);
					return response(puServ.insert(purchase), HttpStatus.OK, true);
				} else {
					return response(result, HttpStatus.OK, true);
				}
			}
		} catch(RuntimeException e) {
			return response(e.getMessage(), HttpStatus.CONFLICT, false);
		}
	}
	
	
	private ResponseEntity<Map<String, Object>> response(Object data, HttpStatus httpstatus, boolean status) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("data", data);
		resultMap.put("status", status);
		return new ResponseEntity<Map<String,Object>>(resultMap, httpstatus);
	}
}
