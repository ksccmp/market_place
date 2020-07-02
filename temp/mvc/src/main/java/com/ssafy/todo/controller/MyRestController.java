package com.ssafy.todo.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.todo.dto.Todo;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest")
public class MyRestController {
	private static Logger logger = LoggerFactory.getLogger(MyRestController.class);
	Map<Long, Todo> todos = new HashMap<Long, Todo>();
	
//	@PostMapping("/todo")
//	public Todo insert(Todo todo) {
//		return todos.put(todo.getId(), todo);
//	}
	
	@GetMapping("/todo/all")
	@ApiOperation("전체 할일 목록 반환")
	public ResponseEntity<Map<String, Object>> getAll() {
		try {
			return response(todos, HttpStatus.OK, true);
		} catch(RuntimeException e) {
			return response(e.getMessage(), HttpStatus.CONFLICT, false);
		}
	}
	
	@PostMapping("/todo")
	@ApiOperation("새로운 Todo 객체 추가")
	public ResponseEntity<Map<String, Object>> insert(@RequestBody Todo todo) {
		try {
			Todo old = todos.put(todo.getId(), todo);
			return response(old, HttpStatus.CREATED, true);
		} catch(RuntimeException e) {
			logger.error("insert 실패", e);
			return response(e.getMessage(), HttpStatus.CONFLICT, false);
		}
	}
	
	// 개별 TODO 조회
	// http://localhost:8080/Todo/rest/todo/1
	@GetMapping("/todo/{id}")
	@ApiOperation("id에 해당하는 목록 반환")
	public ResponseEntity<Map<String, Object>> todo(@PathVariable long id) {
		try {
			Todo todo = todos.get(id);
			return response(todo, HttpStatus.OK, true);
		} catch(RuntimeException e) {
			return response(e.getMessage(), HttpStatus.CONFLICT, false);
		}
	}
	
//	@PutMapping("/todo/{id}")
//	public Todo modify1(@PathVariable long id, Todo todo) {
//		return todos.put(id, todo);
//	}
	
	@PutMapping("/todo/{id}")
	@ApiOperation("id에 해당하는 할일 수정")
	public Todo modify1(@PathVariable long id, @RequestBody Todo todo) {
		return todos.put(id, todo);
	}
	
	@PutMapping("/todo")
	@ApiOperation("할일 수정")
	public ResponseEntity<Map<String, Object>> modify2(Todo todo) {
		try {
			return response(todos.put(todo.getId(), todo), HttpStatus.CREATED, true);
		} catch(RuntimeException e) {
			return response(e.getMessage(), HttpStatus.CONFLICT, false);
		}
	}
	
	@DeleteMapping("/todo/{id}")
	@ApiOperation("id에 해당하는 할일 삭제")
	public ResponseEntity<Map<String, Object>> delete(@PathVariable long id) {
		try {
			return response(todos.remove(id), HttpStatus.NO_CONTENT, true);
		} catch(RuntimeException e) {
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
