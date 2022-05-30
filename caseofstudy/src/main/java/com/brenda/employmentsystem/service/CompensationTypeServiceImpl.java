package com.brenda.employmentsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brenda.employmentsystem.model.CompensationType;
import com.brenda.employmentsystem.repository.CompensationTypeRepository;

@Service
public class CompensationTypeServiceImpl implements CompensationTypeService{
	
	@Autowired
	private CompensationTypeRepository compensationTypeRepository;

	@Override
	public List<CompensationType> getAllCompensationTypes() {
		return compensationTypeRepository.findAll();
	}

}
