package com.ssafy.model.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.Product;

@Repository
public class ProductRepoImpl implements ProductRepo {
	private static Logger logger = LoggerFactory.getLogger(ProductRepoImpl.class);
	private String ns = "com.ssafy.productmapper.";
	
	@Autowired
	SqlSession session;
	
	@Override
	public int delete(String id) {
		logger.trace("delete: {}", id);
		return 0;
	}
	
	@Override
	public int insert(Product product) {
		logger.trace("insert: {}", product);
		return session.insert(ns+"insert", product);
	}
	
	@Override
	public Product select(String id) {
		logger.trace("select: {}", id);
		return null;
	}
	@Override
	public List<Product> selectAll() {
		logger.trace("selectAll");
		return session.selectList(ns+"selectAll");
	}
	@Override
	public int update(Product product) {
		logger.trace("update: {}", product);
		return 0;
	}
}
