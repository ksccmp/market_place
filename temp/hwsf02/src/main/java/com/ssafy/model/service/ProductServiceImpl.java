package com.ssafy.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dto.Product;
import com.ssafy.model.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {
	private static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	ProductRepo repo;
	
	@Autowired
	public ProductServiceImpl(ProductRepo repo) {
		this.repo = repo;
	}
	
	@Override
	public int delete(String id) {
		logger.trace("delete, {}", id);
		return 0;
	}
	
	@Override
	public ProductRepo getRepo() {
		logger.trace("getRepo");
		return repo;
	}
	
	@Override
	public int insert(Product product) {
		logger.trace("insert, {}", product);
		return 0;
	}
	
	@Override
	public Product select(String id) {
		logger.trace("select, {}", id);
		return null;
	}
	
	@Override
	public List<Product> selectAll() {
		logger.trace("selectAll");
		return null;
	}
	
	@Override
	public int update(Product product) {
		logger.trace("update, {}", product);
		return 0;
	}
}
