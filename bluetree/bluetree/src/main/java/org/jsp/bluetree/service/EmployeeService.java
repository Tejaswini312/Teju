package org.jsp.bluetree.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.jsp.bluetree.dao.EmployeeDao;
import org.jsp.bluetree.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao dao;

	public void insert(Employee employee) {
		employee.setStatus(false);
		String dob = employee.getDob();
		LocalDate dobDate = LocalDate.parse(dob);
		LocalDate curDate = LocalDate.now();
		int age = Period.between(dobDate, curDate).getYears();
		employee.setAge(age);
		dao.insert(employee);
	}

	public List<Employee> fetch() {
		return dao.fetch();
	}

	public void delete(int id) {
		dao.removeEmployee(id);
	}

	public Employee fetchById(int id) {
		return dao.fetchById(id);
	}

	public void update(Employee employee) {
		String dob = employee.getDob();
		LocalDate dobDate = LocalDate.parse(dob);
		LocalDate curDate = LocalDate.now();
		int age = Period.between(dobDate, curDate).getYears();
		employee.setAge(age);
		dao.update(employee);
	}

}
