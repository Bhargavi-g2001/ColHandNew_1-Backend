package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.adminlogin;
@Repository
public interface AdminRepository extends JpaRepository<adminlogin, String> {
	
	adminlogin findByUsername(String username);

}
