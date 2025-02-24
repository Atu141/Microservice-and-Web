package com.github.Atu141.ms_employee.EmployeeDTO;

import com.github.Atu141.ms_employee.employees.Employee;

import java.time.LocalDate;

public record EmployeeResponseDTO(
        long id,
        String name,
        String cpf,
        String email,
        Double salary,
        LocalDate birthDate) {


    public EmployeeResponseDTO(Employee entity){
    this(
            entity.getId(),
            entity.getName(),
            entity.getCpf(),
            entity.getEmail(),
            entity.getSalary(),
            entity.getBirthDate());

    }
}