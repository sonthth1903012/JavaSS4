package com.example.csw_test.jpa.dto;

import com.example.csw_test.jpa.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    EmployeeDto toEmployeeDTO(Employee employee);
    List<EmployeeDto> toEmployeeDTOs(List<Employee> employees);
    Employee toEmployee(EmployeeDto employeeDto);

}
