package market.place.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import market.place.dto.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
	private String ns = "market.place.product.";
	
	@Autowired
	SqlSession session;
	
	@Override
	public List<Product> selectAll() {
		return session.selectList(ns + "selectAll");
	}
	
	@Override
	public int insert(Product product) {
		return session.insert(ns + "insert", product);
	}
}
