package com.github.Atu141.ms_employee.employeeController;


import com.github.Atu141.ms_employee.EmployeeDTO.EmployeeRequestDTO;
import com.github.Atu141.ms_employee.EmployeeDTO.EmployeeResponseDTO;
import com.github.Atu141.ms_employee.employeeService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>>findAll(){
        List<EmployeeResponseDTO> dto = service.findall();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> findById(@PathVariable Long id){
    EmployeeResponseDTO dto = service.findById(id);
    return ResponseEntity.ok(dto);
    }

    public ResponseEntity<EmployeeResponseDTO> insert(@RequestBody EmployeeRequestDTO requestDTO){
            EmployeeResponseDTO dto = service.insert(requestDTO);

            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(dto.id())
                    .toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO>update(@PathVariable long id,@RequestBody EmployeeRequestDTO  requestDTO){
        EmployeeResponseDTO dto = service.update(id, requestDTO);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
