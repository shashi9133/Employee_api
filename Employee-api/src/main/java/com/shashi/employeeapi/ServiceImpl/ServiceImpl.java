package com.shashi.employeeapi.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shashi.employeeapi.Entity.Employee;
import com.shashi.employeeapi.Repository.EmployeeRepository;
import com.shashi.employeeapi.Service.EmployeeService;

@Service
public class ServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Override
	public Employee createEmploye(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeById(Long id) {
		return employeeRepo.findById(id);
	}

	@Override
	public Employee updateEmployee(Long id, Employee updatedEmployee) {
		return employeeRepo.findById(id).map(employee ->{
			employee.setFirstName(updatedEmployee.getFirstName());
			employee.setSecondName(updatedEmployee.getSecondName());
			employee.setEmail(updatedEmployee.getEmail());
			return employeeRepo.save(employee);
		}).orElse(null);
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepo.deleteById(id);
	}

}
