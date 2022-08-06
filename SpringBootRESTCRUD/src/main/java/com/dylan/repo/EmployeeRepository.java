package com.dylan.repo;
import com.dylan.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
}
