package com.brenda.employmentsystem.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brenda.employmentsystem.model.Compensation;
import com.brenda.employmentsystem.model.Employee;


@Repository
public interface CompensationRepository extends JpaRepository<Compensation, Long>{
	
	@Query("SELECT c FROM COMPENSATIONS c WHERE c.employee_id LIKE %?1%")
	public List<Compensation> findByEmployee(Employee employee);
	
	
	
}
