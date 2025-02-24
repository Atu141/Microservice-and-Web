package com.github.Atu141.ms_employee.employeeService;

import com.github.Atu141.ms_employee.EmployeeDTO.EmployeeRequestDTO;
import com.github.Atu141.ms_employee.EmployeeDTO.EmployeeResponseDTO;
import com.github.Atu141.ms_employee.employeeRepository.EmployeeRepository;
import com.github.Atu141.ms_employee.employees.Employee;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Transactional(readOnly = true)
    public List<EmployeeResponseDTO> findall(){
        List<Employee> list = repository.findAll();
        return list.stream().map(EmployeeResponseDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public EmployeeResponseDTO findById(Long id){
        Employee entity = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Recurso não encontrado. Id" + id)
        );
        return new EmployeeResponseDTO(entity);
    }

    @Transactional
    public EmployeeResponseDTO insert (EmployeeRequestDTO requestDTO){
        Employee entity = new Employee();
        toEntity(requestDTO, entity);
        entity = repository.save(entity);
        return new EmployeeResponseDTO(entity);
    }

    private void toEntity(EmployeeRequestDTO requestDTO, Employee entity) {
        entity.setName(requestDTO.name());
        entity.setEmail(requestDTO.email());
        entity.setCpf(requestDTO.cpf());
        entity.setSalary(requestDTO.salary());
        entity.setBirthDate(requestDTO.birthDate());
    }

    @Transactional
    public EmployeeResponseDTO update(Long id, EmployeeRequestDTO requestDTO){
        try{
            Employee entity = repository.getReferenceById(id);
            toEntity(requestDTO, entity);
            return new EmployeeResponseDTO(entity);
        }catch (EntityNotFoundException ex){
            throw new EntityNotFoundException("Recusso não encontrado. Id: "+ id);
        }
    }

    public void delete(Long id){
        if (!repository.existsById(id)){
            throw new EntityNotFoundException("Recuso não encontrado. Id: " + id);
        }
        repository.deleteById(id);
    }
}
