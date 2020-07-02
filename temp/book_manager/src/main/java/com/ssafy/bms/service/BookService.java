package com.ssafy.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.bms.dto.Book;
import com.ssafy.bms.repo.BookRepo;

@Service
public class BookService {
	
	@Autowired
	BookRepo repo;
	
	public Book select(String isbn) {
		return repo.select(isbn);
	}
	
	public List<Book> select() {
		return repo.select();
	}
	
	@Transactional
	public int insert(Book book) {
		return repo.insert(book);
	}
	
	@Transactional
	public int delete(String isbn) {
		return repo.delete(isbn);
	}
	
	@Transactional
	public int update(Book book) {
		return repo.update(book);
	}
}
