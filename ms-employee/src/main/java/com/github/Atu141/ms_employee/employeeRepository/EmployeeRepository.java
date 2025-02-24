package com.github.Atu141.ms_employee.employeeRepository;

import com.github.Atu141.ms_employee.employees.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
