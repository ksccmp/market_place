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
	public Product selectById(int id) {
		return session.selectOne(ns + "selectById", id);
	}
	
	@Override
	public int insert(Product product) {
		return session.insert(ns + "insert", product);
	}
	
	@Override
	public int delete(Product product) {
		return session.delete(ns + "delete", product);
	}
	
	@Override
	public int updateByCount(Product product) {
		return session.update(ns + "updateByCount", product);
	}
}
