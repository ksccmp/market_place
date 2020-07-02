package com.ssafy.edu.vue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.edu.vue.dao.EmployeeDAO;
import com.ssafy.edu.vue.dto.DepartmentDto;
import com.ssafy.edu.vue.dto.EmployeeDto;

@SpringBootTest
@Transactional
class DaoTest {
	
	@Autowired
	EmployeeDAO dao;
	
	@Test
	void test() {
		List<EmployeeDto> list = dao.findAllEmployees();
		assertEquals(list.size(), 25);
		
		boolean result = dao.addEmployee(new EmployeeDto(500, "김성찬", "tj", "08-MAR-1990", 3, "대표", 101, (double)10000, null));
		
		assertEquals(result, true);
		
		result = dao.deleteEmployee(24);
		assertEquals(result, true);
		
		List<DepartmentDto> lists = dao.findAllDepartments();
		assertEquals(lists.size(), 12);
		
		list = dao.findAllTitles();
		assertEquals(list.size(), 25);
		
		EmployeeDto employee = dao.findEmployeeById(1);
		assertEquals(employee.getName(), "박구곤");
		
		list = dao.findLikeEmployees("박");
		assertEquals(list.size(), 2);
		
		int size = dao.getEmployeesTotal();
		assertEquals(size, 25);
		
		result = dao.updateEmployee(new EmployeeDto(1, "김성찬", "tjkk", "08-MAR-1990", 3, "대표", 101, (double)10000, null));
		assertEquals(result, true);
		
		assertEquals(dao.findAllDepCounts().size(), 11);
		
		assertEquals(dao.findAllDeptEmps().size(), 25);
		
		assertEquals(dao.findDepartmentsBydeptid(110).size(), 4);
		
		assertEquals(dao.findDepartmentsByname("기획부").size(), 14);
		
		assertEquals(dao.findEmployeesByManagerId(10).size(), 1);
	}
}