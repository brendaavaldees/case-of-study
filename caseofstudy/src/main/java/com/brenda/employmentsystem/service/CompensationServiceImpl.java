package com.brenda.employmentsystem.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brenda.employmentsystem.model.Compensation;
import com.brenda.employmentsystem.model.Employee;
import com.brenda.employmentsystem.repository.CompensationRepository;

@Service
public class CompensationServiceImpl implements CompensationService{
	
	@Autowired
	private CompensationRepository compensationRepository;
	

	@Override
	public List<Compensation> getCompensationsByEmployeeAndKeyword(Employee employee, String keyword) {
		if(employee != null && keyword != null) {
			
			return compensationRepository.findByEmployee(employee).stream()
	    			.filter(compensation -> keyword.contains(Float.toString(compensation.getAmount()))
	    							|| keyword.contains(compensation.getDescription())
	    							|| keyword.contains(compensation.getType().toString()))
	    							
	    			.collect(Collectors.toList());
			
		}else if(keyword == null) {
			return compensationRepository.findByEmployee(employee);
		}
		return compensationRepository.findAll();
	}

	@Override
	public void saveCompensation(Compensation compensation) {
		this.compensationRepository.save(compensation);
		
	}

	@Override
	public Compensation getCompensationById(long id) {
		Optional<Compensation> optional = compensationRepository.findById(id);
		Compensation compensation = null;
		if(optional.isPresent()) {
			compensation = optional.get();
		}else{
			throw new RuntimeException("Theres no compensation with an id: " + id);
		}
		return compensation;
	}

}
