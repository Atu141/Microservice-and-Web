package com.github.Atu141.ms_employee.EmployeeDTO;

import java.time.LocalDate;

public record EmployeeRequestDTO(
       String name,
       String cpf,
       String email,
       Double salary,
       LocalDate birthDate) {
}
