package com.brenda.employmentsystem.service;

import java.util.List;

import com.brenda.employmentsystem.model.Compensation;
import com.brenda.employmentsystem.model.Employee;

public interface CompensationService {
	
	List<Compensation> getAllCompensations(Employee employee);
	
	void saveCompensation(Compensation compensation);
	
	Compensation getCompensationById(long id);

}
