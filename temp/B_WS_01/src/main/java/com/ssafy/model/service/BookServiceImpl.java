package com.ssafy.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dto.Book;
import com.ssafy.model.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	private static Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
	private BookRepository bookRepo;
	
	@Autowired
	public BookServiceImpl(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
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
		logger.trace("selectAll: ");
		return null;
	}
	
	@Override
	public int update(Book book) {
		logger.trace("update: {}", book);
		return 0;
	}
}
