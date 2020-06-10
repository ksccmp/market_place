package market.place.repository;

import java.util.List;

import market.place.dto.Product;

public interface ProductRepository {
	public List<Product> selectAll();
	
	public int insert(Product product);
}
