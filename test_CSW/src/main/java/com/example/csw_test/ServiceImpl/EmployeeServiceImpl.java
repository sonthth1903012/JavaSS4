package com.example.csw_test.ServiceImpl;

import com.example.csw_test.jpa.Employee;
import com.example.csw_test.repository.EmployeeRepository;
import com.example.csw_test.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> listEmployee() {
        try{
            List<Employee>  listEmployee = employeeRepository.findAll();
            return listEmployee;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee getEmployeeById(int employee_id) {
        try{
            Employee employee = employeeRepository.getById(employee_id);
            return employee;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean saveEmployee(Employee employee) {
        try{
            employeeRepository.save(employee);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        try{
            employeeRepository.save(employee);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteEmployee(int employee_id) {
        try{
            employeeRepository.deleteById(employee_id);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

}
