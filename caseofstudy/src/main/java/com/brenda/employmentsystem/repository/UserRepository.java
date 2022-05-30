package com.brenda.employmentsystem.repository;

import com.brenda.employmentsystem.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
