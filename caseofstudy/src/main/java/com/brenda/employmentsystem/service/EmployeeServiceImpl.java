package com.brenda.employmentsystem.service;

import java.util.List;
import java.util.Optional;

import com.brenda.employmentsystem.model.Employee;
import com.brenda.employmentsystem.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees(String keyword) {
        return employeeRepository.findAll();
    }

	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
		
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if(optional.isPresent()) {
			employee = optional.get();
		}else{
			throw new RuntimeException("Theres no employee with an id: " + id);
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {
		this.employeeRepository.deleteById(id);
	}
    
}
