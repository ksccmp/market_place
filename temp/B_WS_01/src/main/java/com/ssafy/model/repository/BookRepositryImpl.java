package com.ssafy.model.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.Book;

@Repository
public class BookRepositryImpl implements BookRepository {
	private static Logger logger = LoggerFactory.getLogger(BookRepositryImpl.class);

	@Override
	public int delete(String isbn) {
		logger.trace("delete: {}", isbn);
		return 0;
	}
	
	@Override
	public int insert(Book book) {
		logger.trace("insert: {}", book);
		return 0;
	}
	
	@Override
	public Book select(String isbn) {
		logger.trace("select: {}", isbn);
		return null;
	}
	
	@Override
	public List<Book> selectAll() {
		logger.trace("selectAll:");
		return null;
	}
	
	@Override
	public int update(Book book) {
		logger.trace("update: {}", book);
		return 0;
	}
}
