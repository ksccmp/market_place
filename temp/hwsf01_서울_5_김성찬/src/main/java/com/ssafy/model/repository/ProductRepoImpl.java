package com.ssafy.model.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.Product;

@Repository
public class ProductRepoImpl implements ProductRepo {
	private static Logger logger = LoggerFactory.getLogger(ProductRepoImpl.class);
	
	@Override
	public int delete(String id) {
		logger.trace("delete: {}", id);
		return 0;
	}
	
	@Override
	public int insert(Product product) {
		logger.trace("insert: {}", product);
		return 0;
	}
	
	@Override
	public Product select(String id) {
		logger.trace("select: {}", id);
		return null;
	}
	@Override
	public List<Product> selectAll() {
		logger.trace("selectAll");
		return null;
	}
	@Override
	public int update(Product product) {
		logger.trace("update: {}", product);
		return 0;
	}
}
