package com.ssafy.bms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.bms.dto.Book;
import com.ssafy.bms.service.BookService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/rest")
@Slf4j
@CrossOrigin("*")
public class BookRestController {
	
	@Autowired
	BookService service;
	
	@GetMapping("/book/{isbn}")
	@ApiOperation("isbn을 이용한 Book 데이터 조회")
	public ResponseEntity<Map<String, Object>> select(@PathVariable String isbn) {
		try {
			Book book = service.select(isbn);
			return response(book, HttpStatus.OK, true);
		} catch(RuntimeException e) {
			log.error("조회 실패");
			return response(e.getMessage(), HttpStatus.CONFLICT, false);
		}
	}
	
	@GetMapping("/book")
	@ApiOperation("전체 Book 데이터 조회")
	public ResponseEntity<Map<String, Object>> select() {
		try {
			List<Book> books = service.select();
			return response(books, HttpStatus.OK, true);
		} catch(RuntimeException e) {
			log.error("조회 실패");
			return response(e.getMessage(), HttpStatus.CONFLICT, false);
		}
	}
	
	@PostMapping("/book")
	@ApiOperation("Book 데이터 추가")
	public ResponseEntity<Map<String, Object>> insert(@RequestBody Book book) {
		try {
			return response(service.insert(book), HttpStatus.CREATED, true);
		} catch(RuntimeException e) {
			log.error("추가 실패");
			return response(e.getMessage(), HttpStatus.CONFLICT, false);
		}
	}
	
	@PutMapping("/book")
	@ApiOperation("Book 데이터 변경")
	public ResponseEntity<Map<String, Object>> update(@RequestBody Book book) {
		try {
			return response(service.update(book), HttpStatus.CREATED, true);
		} catch(RuntimeException e) {
			log.error("변경 실패");
			return response(e.getMessage(), HttpStatus.CONFLICT, false);
		}
	}
	
	@DeleteMapping("/book/{isbn}")
	@ApiOperation("Book 데이터 삭제")
	public ResponseEntity<Map<String, Object>> delete(@PathVariable String isbn) {
		try {
			return response(service.delete(isbn), HttpStatus.OK, true);
		} catch(RuntimeException e) {
			log.error("삭제 실패");
			return response(e.getMessage(), HttpStatus.CONFLICT, false);
		}
	}
	
	private ResponseEntity<Map<String, Object>> response(Object data, HttpStatus httpstatus, boolean status) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("status", status);
		resultMap.put("data", data);
		// 상태와 함께 Map 반환
		return new ResponseEntity<Map<String,Object>>(resultMap, httpstatus);
	}
}
