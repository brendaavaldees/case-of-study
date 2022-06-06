package com.brenda.employmentsystem.repository;

import com.brenda.employmentsystem.model.User;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT u FROM USERS u WHERE u.user_name = :username")
	public User getUserByUsername(@Param("username") String username);
    
}
