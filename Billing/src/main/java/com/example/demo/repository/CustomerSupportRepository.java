package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CustomerSupportLogin;
import com.example.demo.entity.adminlogin;

public interface CustomerSupportRepository extends JpaRepository<CustomerSupportLogin, Integer> {

	CustomerSupportLogin findByUsername(String username);
	
}
