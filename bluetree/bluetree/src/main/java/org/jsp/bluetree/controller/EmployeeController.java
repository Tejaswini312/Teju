package org.jsp.bluetree.controller;

import java.util.List;

import org.jsp.bluetree.dto.Employee;
import org.jsp.bluetree.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	@Autowired
	Employee employee;

	@Autowired
	EmployeeService service;

	@RequestMapping("loadEmployee")
	public ModelAndView load() {
		ModelAndView andView = new ModelAndView("addEmployee");
		andView.addObject("employee", employee);
		return andView;
	}

	@RequestMapping("addEmployee")
	public String add(@ModelAttribute Employee employee) {
		service.insert(employee);
		return "redirect:fetchAll";
	}

	@RequestMapping("fetchAll")
	public ModelAndView fetchAll() {
		List<Employee> list = service.fetch();
		ModelAndView andView = new ModelAndView("viewEmployee");
		andView.addObject("list", list);
		return andView;
	}
	
	@RequestMapping("deleteEmployee")
	public String deleteEmployee(@RequestParam int id) {
		service.delete(id);
		return "redirect:fetchAll";
	}
	
	@RequestMapping("editEmployee")
	public ModelAndView edit(@RequestParam int id) {
		Employee employee=service.fetchById(id);
		ModelAndView andView = new ModelAndView("editEmployee");
		andView.addObject("employee", employee);
		return andView;
	}
	
	@RequestMapping("updateEmployee")
	public String update(@ModelAttribute Employee employee) {
		service.update(employee);
		return "redirect:fetchAll";
	}
}
