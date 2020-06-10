package market.place.service;

import java.util.List;

import market.place.dto.Product;

public interface ProductService {
	public List<Product> selectAll();
	
	public int insert(Product product);
}
