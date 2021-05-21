package com.example.csw_test.api;

import com.example.csw_test.jpa.Employee;
import com.example.csw_test.jpa.dto.EmployeeDto;
import com.example.csw_test.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@Controller
@RequestMapping(path = "/api/v1/employees")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeController(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @GetMapping
    public ResponseEntity<Page<Employee>> getAllEmployee(Pageable pageable) {
        return ResponseEntity.ok(employeeRepository.findAll(pageable));
    }

    @GetMapping("/{id}")
    public EmployeeDto getById(@PathVariable Integer id) {
        EmployeeDto optionalEmployee = employeeMapper.toEmployeeDTO(employeeRepository.findById(id).get());
        return optionalEmployee;
    }

    @PostMapping
    public ResponseEntity<Employee> create(@Valid @RequestBody Employee employee) {
        Employee employeeSaved = employeeRepository.save(employee);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employeeSaved.getId()).toUri();
        return ResponseEntity.created(location).body(employeeSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Integer id, @Valid @RequestBody Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (!optionalEmployee.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        employee.setId(optionalEmployee.get().getId());
        employeeRepository.save(employee);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Employee optionalEmployee = employeeRepository.findById(id).get();
        if (optionalEmployee != null) {
            employeeRepository.deleteById(id);
            return new ResponseEntity<Employee>(optionalEmployee, HttpStatus.OK);
        }
        return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.NOT_FOUND);
    }


}
