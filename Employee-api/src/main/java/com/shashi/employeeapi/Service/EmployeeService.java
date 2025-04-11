package com.shashi.employeeapi.Service;

import java.util.List;
import java.util.Optional;

import com.shashi.employeeapi.Entity.Employee;

public interface EmployeeService {

	Employee createEmploye(Employee employee);
	List<Employee> getAllEmployees();
	Optional<Employee> getEmployeeById(Long id);
	Employee updateEmployee(Long id,Employee employee);
	void deleteEmployee(Long id);
}
