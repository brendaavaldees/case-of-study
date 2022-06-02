package com.brenda.employmentsystem.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.brenda.employmentsystem.model.Employee;
import com.brenda.employmentsystem.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployeesByKeyword(String keyword) {
    	if(keyword != null) {
    		return employeeRepository.findAll().stream()
    			.filter(employee -> keyword.contains(employee.getFirstName())
    							|| keyword.contains(employee.getMiddleName())
    							|| keyword.contains(employee.getLastName())
    							|| keyword.contains(employee.getPosition())
    							|| keyword.contains(employee.getBirthday()))
    			.collect(Collectors.toList());
    		

    		
    	}
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
