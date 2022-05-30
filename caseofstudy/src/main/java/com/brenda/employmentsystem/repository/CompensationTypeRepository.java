package com.brenda.employmentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brenda.employmentsystem.model.CompensationType;

@Repository
public interface CompensationTypeRepository extends JpaRepository<CompensationType, Long>{

}
