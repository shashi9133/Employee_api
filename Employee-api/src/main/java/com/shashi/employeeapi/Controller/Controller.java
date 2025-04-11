package com.shashi.employeeapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shashi.employeeapi.Entity.Employee;
import com.shashi.employeeapi.Service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class Controller {

	@Autowired
	private EmployeeService employeeService;
	
	//CREAT
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		return ResponseEntity.ok(employeeService.createEmploye(employee));
	}
	
	//READ ALL
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees(){
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
		return employeeService.getEmployeeById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
		Employee update = employeeService.updateEmployee(id, employee);
		if(update !=null) {
			return ResponseEntity.ok(update);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
		employeeService.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
