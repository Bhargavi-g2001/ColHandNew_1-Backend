package com.example.demo.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PendingCustomerdetails;

@Repository
public interface PendingCustomerdetailsRepository extends JpaRepository<PendingCustomerdetails, Integer> {
 
//	<Optional>PendingCustomerdetails findById(int Customer_id);
	List<PendingCustomerdetails> findByDuedate(java.util.Date today);
	
	List<PendingCustomerdetails>  findByMobile(String mobile);
	List<PendingCustomerdetails>  findById(int customerId);
	List<PendingCustomerdetails>  findByDays(int days);
//	PendingCustomerdetails findByCustomer_Id(int id); 
	

	
}

