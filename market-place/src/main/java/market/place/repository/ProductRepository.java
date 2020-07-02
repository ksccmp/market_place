package market.place.repository;

import java.util.List;

import market.place.dto.Product;

public interface ProductRepository {
	public List<Product> selectAll();
	
	public Product selectById(int id);
	
	public int insert(Product product);
	
	public int delete(Product product);
	
	public int updateByCount(Product product);
}
