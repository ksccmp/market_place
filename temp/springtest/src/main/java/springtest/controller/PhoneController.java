package springtest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import springtest.dto.Phone;
import springtest.service.PhoneService;

@RestController
@Slf4j
public class PhoneController {
	
	@Autowired
	PhoneService service;
	
	@GetMapping("/select/{num}")
	public ResponseEntity<Map<String, Object>> select(@PathVariable String num) {
		try {
			log.trace("controller: select", num);
			Phone phone = service.select(num);
			return response(phone, HttpStatus.OK, true);
		} catch(RuntimeException e) {
			log.error("검색 실패");
			return response(e.getMessage(), HttpStatus.CONFLICT, false);
		}
	}
	
	@GetMapping("/selectAll")
	public ResponseEntity<Map<String, Object>> selectAll() {
		try {
			log.trace("controller: selectAll");
			List<Phone> phones = service.selectAll();
			return response(phones, HttpStatus.OK, true);
		} catch(RuntimeException e) {
			log.error("검색 실패");
			return response(e.getMessage(), HttpStatus.CONFLICT, false);
		}
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Map<String, Object>> insert(@RequestBody Phone phone) {
		try {
			return response(service.insert(phone), HttpStatus.CREATED, true);
		} catch(RuntimeException e) {
			log.error("등록 실패");
			return response(e.getMessage(), HttpStatus.CONFLICT, false);
		}
	}
	
	@DeleteMapping("/delete/{num}")
	public ResponseEntity<Map<String, Object>> delete(@PathVariable String num) {
		try {
			log.trace("controller: delete", num);
			return response(service.delete(num), HttpStatus.OK, true);
		} catch(RuntimeException e) {
			log.error("삭제 실패");
			return response(e.getMessage(), HttpStatus.CONFLICT, false);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Map<String, Object>> update(@RequestBody Phone phone) {
		try {
			log.trace("controller: update", phone);
			return response(service.update(phone), HttpStatus.OK, true);
		} catch(RuntimeException e) {
			log.error("수정 실패");
			return response(e.getMessage(), HttpStatus.CONFLICT, false);
		}
	}
	
	private ResponseEntity<Map<String, Object>> response(Object data, HttpStatus httpstatus, boolean status) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", data);
		map.put("status", status);
		return new ResponseEntity<Map<String,Object>>(map, httpstatus);
	}
}
