package com.dylan.service;
import java.util.List;
import java.util.Optional;

import com.dylan.model.Employee;
import com.dylan.repo.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository repo;
	
	public List<Employee> getAllEmps() {
		return repo.findAll();
	}
	public Optional<Employee> getEmpById(int id) {
		return repo.findById(id);
	}
	public void deleteEmp(Integer id) {
		repo.deleteById(id);
	}
	public void addEmp(Employee emp) {
		repo.save(emp);
	}
	public void saveOrUpdate(Employee emp) {
		repo.save(emp);
	}
}  
