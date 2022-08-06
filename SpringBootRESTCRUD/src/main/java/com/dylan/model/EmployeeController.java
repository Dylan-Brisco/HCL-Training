package com.dylan.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dylan.service.EmployeeService;

import java.util.Optional;



@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	@GetMapping("/employees")
	public List<Employee> listAllEmp() {
		return service.getAllEmps();
	}
	@GetMapping("/employees/{id}")
	public Optional<Employee> getEmpId(@PathVariable Integer id) {
		Optional<Employee> emp = service.getEmpById(id);
		return service.getEmpById(id);
	}
	@PostMapping("/employees")
	public void addEmp(@RequestBody Employee emp) {
		service.addEmp(emp);
	}
	@DeleteMapping("/employees/{id}")
	public void deleteEmp(@PathVariable Integer id) {
		service.deleteEmp(id);
	}
	
	@PutMapping("/employees")
	public void updateEmployee(@RequestBody Employee employee) {
		service.saveOrUpdate(employee);
	}	
}
