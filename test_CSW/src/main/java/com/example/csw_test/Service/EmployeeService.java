package com.example.csw_test.service;

import com.example.csw_test.jpa.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> listEmployee();
    Employee getEmployeeById(int employee_id);
    boolean saveEmployee(Employee employee);
    boolean deleteEmployee(int employee_id);
    boolean updateEmployee(Employee employee);
}
