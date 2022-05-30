package com.brenda.employmentsystem.repository;

import com.brenda.employmentsystem.model.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
	public List<Employee> findAll();
}
