package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CustomerSupportLogin;
import com.example.demo.entity.Customerdetails;
import java.util.List;


@Repository

public interface CustomerDetailsRepository extends JpaRepository<Customerdetails, Integer> {
	
//	Customerdetails  findByCustomer_id(int customer_id);
	
}
