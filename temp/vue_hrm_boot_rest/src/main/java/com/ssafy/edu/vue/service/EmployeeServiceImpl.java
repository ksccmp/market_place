package com.ssafy.edu.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.edu.vue.dao.EmployeeDAO;
import com.ssafy.edu.vue.dto.DepCountDto;
import com.ssafy.edu.vue.dto.DepartmentDto;
import com.ssafy.edu.vue.dto.DepartmentEmpDto;
import com.ssafy.edu.vue.dto.EmployeeDto;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDAO dao;
	
	@Override
	@Transactional
	public boolean addEmployee(EmployeeDto emp) {
		return dao.addEmployee(emp);
	}
	
	@Override
	@Transactional
	public boolean deleteEmployee(int id) {
		return dao.deleteEmployee(id);
	}
	
	@Override
	public List<DepartmentDto> findAllDepartments() {
		return dao.findAllDepartments();
	}
	
	@Override
	public List<EmployeeDto> findAllEmployees() {
		return dao.findAllEmployees();
	}
	
	@Override
	public List<EmployeeDto> findAllTitles() {
		return dao.findAllTitles();
	}
	
	@Override
	public EmployeeDto findEmployeeById(int id) {
		return dao.findEmployeeById(id);
	}
	
	@Override
	public List<EmployeeDto> findLikeEmployees(String name) {
		return dao.findLikeEmployees(name);
	}
	
	@Override
	public int getEmployeesTotal() {
		return dao.getEmployeesTotal();
	}
	
	@Override
	@Transactional
	public boolean updateEmployee(EmployeeDto emp) {
		return dao.updateEmployee(emp);
	}
	
	@Override
	public List<DepCountDto> findAllDepCounts() {
		return dao.findAllDepCounts();
	}
	
	@Override
	public List<DepartmentEmpDto> findAllDeptEmps() {
		return dao.findAllDeptEmps();
	}
	
	@Override
	public List<EmployeeDto> findDepartmentsBydeptid(int dept_id) {
		return dao.findDepartmentsBydeptid(dept_id);
	}
	
	@Override
	public List<EmployeeDto> findDepartmentsByname(String name) {
		return dao.findDepartmentsByname(name);
	}
	
	@Override
	public List<EmployeeDto> findEmployeesByManagerId(int managerId) {
		return dao.findEmployeesByManagerId(managerId);
	}
}
