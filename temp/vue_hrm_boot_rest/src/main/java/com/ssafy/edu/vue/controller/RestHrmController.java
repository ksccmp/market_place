package com.ssafy.edu.vue.controller;

import java.util.List;

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

import com.ssafy.edu.vue.dto.EmployeeDto;
import com.ssafy.edu.vue.help.NumberResult;
import com.ssafy.edu.vue.service.EmployeeService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@CrossOrigin({"*"})
@Slf4j
public class RestHrmController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/findAllEmployees")
	@ApiOperation(value="전체 사원의 정보를 반환한다.", response=List.class)
	public Object findAllEmployees() {
		log.trace("findAllEmployees");
		try {
			List<EmployeeDto> emps = service.findAllEmployees();
			return new ResponseEntity<Object>(emps, HttpStatus.OK);
		} catch(RuntimeException e) {
			log.error("findAllEmployees", e);
			throw e;
		}
	}
	
	@PostMapping("/addEmployee")
	@ApiOperation(value="새로운 사원 정보를 입력하고 그 사원의 사원정보를 반환한다.")
	public ResponseEntity<Object> addEmployee(@RequestBody EmployeeDto emp) {
		log.trace("addEmployee");
		try {
			boolean result = service.addEmployee(emp);
			NumberResult nr = null;
			if(result) {
				nr = new NumberResult("addEmployee", emp.getId(), "Success");
			} else {
				nr = new NumberResult("addEmployee", emp.getId(), "Fail");
			}
			return new ResponseEntity<Object>(nr, HttpStatus.OK);
		} catch(RuntimeException e) {
			log.error("addEmployee", e);
			throw e;
		}
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	@ApiOperation(value="사원 id를 받고 삭제")
	public ResponseEntity<Object> deleteEmployee(@PathVariable int id) {
		log.trace("deleteEmployee");
		try {
			return new ResponseEntity<Object>(service.deleteEmployee(id), HttpStatus.OK);
		} catch(RuntimeException e) {
			log.error("deleteEmployee", e);
			throw e;
		}
	}
	
	@GetMapping("/findAllDepartments")
	@ApiOperation(value="모든 부서정보를 찾기")
	public ResponseEntity<Object> findAllDepartments() {
		log.trace("findAllDepartments");
		try {
			return new ResponseEntity<Object>(service.findAllDepartments(), HttpStatus.OK);
		} catch(RuntimeException e) {
			log.error("findAllDepartments", e);
			throw e;
		}
	}
	
	@GetMapping("/findAllTitles")
	@ApiOperation(value="모든 타이틀 찾기")
	public ResponseEntity<Object> findAllTitles() {
		log.trace("findAllTitle");
		try {
			return new ResponseEntity<Object>(service.findAllTitles(), HttpStatus.OK);
		} catch(RuntimeException e) {
			log.error("findAllTitles", e);
			throw e;
		}
	}
	
	@GetMapping("/findEmployeeById/{id}")
	@ApiOperation(value="아이디를 이용해서 사원 찾기")
	public ResponseEntity<Object> findEmployeeById(@PathVariable int id) {
		log.trace("findEmployeeById");
		try {
			return new ResponseEntity<Object>(service.findEmployeeById(id), HttpStatus.OK);
		} catch(RuntimeException e) {
			log.error("findEmployeeById", e);
			throw e;
		}
	}
	
	@GetMapping("/findLikeEmployes/{name}")
	@ApiOperation(value="유사한 이름의 사원 찾기")
	public ResponseEntity<Object> findLikeEmployees(@PathVariable String name) {
		log.trace("findLikeEmployees");
		try {
			return new ResponseEntity<Object>(service.findLikeEmployees(name), HttpStatus.OK);
		} catch(RuntimeException e) {
			log.error("findLikeEmployees", e);
			throw e;
		}
	}
	
	@GetMapping("/getEmployeesTotal")
	@ApiOperation(value="모든 부서원 인원 구하기")
	public ResponseEntity<Object> getEmployeesTotal() {
		log.trace("getEmployeesTotal");
		try {
			return new ResponseEntity<Object>(service.getEmployeesTotal(), HttpStatus.OK);
		} catch(RuntimeException e) {
			log.error("getEmployeesTotal", e);
			throw e;
		}
	}
	
	@PutMapping("/updateEmployee")
	@ApiOperation(value="사원정보 수정하기")
	public ResponseEntity<Object> updateEmployee(@RequestBody EmployeeDto emp) {
		log.trace("updateEmployee");
		try {
			return new ResponseEntity<Object>(service.updateEmployee(emp), HttpStatus.OK);
		} catch(RuntimeException e) {
			log.error("updateEmployee", e);
			throw e;
		}
	}
	
	@GetMapping("/findAllDepCounts")
	@ApiOperation(value="모든 부서갯수 구하기")
	public ResponseEntity<Object> findAllDepCounts() {
		log.trace("findAllDepCounts");
		try {
			return new ResponseEntity<Object>(service.findAllDepCounts(), HttpStatus.OK);
		} catch(RuntimeException e) {
			log.error("findAllDepCounts", e);
			throw e;
		}
	}
	
	@GetMapping("/findAllDeptEmps")
	@ApiOperation(value="모든 부서정보와 사원정보연결해서 찾기")
	public ResponseEntity<Object> findAllDeptEmps() {
		log.trace("findAllDeptEmps");
		try {
			return new ResponseEntity<Object>(service.findAllDeptEmps(), HttpStatus.OK);
		} catch(RuntimeException e) {
			log.error("findAllDeptEmps", e);
			throw e;
		}
	}
	
	@GetMapping("/findDepartmentsBydeptid/{id}")
	@ApiOperation(value="아이디에 맞는 부서 찾기")
	public ResponseEntity<Object> findDepartmentsBydeptid(@PathVariable int dept_id) {
		log.trace("findDepartmentsBydeptid");
		try {
			return new ResponseEntity<Object>(service.findDepartmentsBydeptid(dept_id), HttpStatus.OK);
		} catch(RuntimeException e) {
			log.error("findDepartmentsBydeptid", e);
			throw e;
		}
	}
	
	@GetMapping("/findDepartmentsByname/{name}")
	@ApiOperation(value="이름에 맞는 부서 찾기")
	public ResponseEntity<Object> findDepartmentsByname(@PathVariable String name) {
		log.trace("findDepartmentsByname");
		try {
			return new ResponseEntity<Object>(service.findDepartmentsByname(name), HttpStatus.OK);
		} catch(RuntimeException e) {
			log.error("findDepartmentsByname", e);
			throw e;
		}
	}
	
	@GetMapping("/findEmployeeByManagerId/{managerId}")
	@ApiOperation(value="메니저아이디로 사원 찾기")
	public ResponseEntity<Object> findEmployeeByManagerId(@PathVariable int managerId) {
		log.trace("findEmployeeByManagerId");
		try {
			return new ResponseEntity<Object>(service.findEmployeesByManagerId(managerId), HttpStatus.OK);
		} catch(RuntimeException e) {
			log.error("findEmployeeByManagerId", e);
			throw e;
		}
	}
}