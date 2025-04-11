package com.shashi.employeeapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shashi.employeeapi.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
