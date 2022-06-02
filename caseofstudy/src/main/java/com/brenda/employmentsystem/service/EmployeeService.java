package com.brenda.employmentsystem.service;

import java.util.List;

import com.brenda.employmentsystem.model.Employee;

public interface EmployeeService {
	
    List <Employee> getEmployeesByKeyword(String keyword);
    
    void saveEmployee(Employee employee);
    
    Employee getEmployeeById(long id);
    
    void deleteEmployeeById(long id);
}
