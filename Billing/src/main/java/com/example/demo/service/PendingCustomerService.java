package com.example.demo.service;


import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PendingCustomerdetails;
import com.example.demo.repository.PendingCustomerdetailsRepository;

@Service
public class PendingCustomerService {
	
	@Autowired
	private PendingCustomerdetailsRepository repository;
	
	public List<PendingCustomerdetails> getCustomerById(int customerId) {
        return repository.findById(customerId);
    }


	  public List<PendingCustomerdetails> getCustomersWithDueDateToday() {

		  Calendar calendar = Calendar.getInstance();
	        Date today = (Date) calendar.getTime();

	        return repository.findByDuedate(today);

	    }
	  public List<PendingCustomerdetails> getDueCustomers1()

	    {

	    	return repository.findByDays(1);

	    }
	  public List<PendingCustomerdetails> getDueCustomer3()

	    {

	    	return repository.findByDays(3);

	    }
	  public List<PendingCustomerdetails> getDueCustomer5()

	    {

	    	return repository.findByDays(5);

	    }

}
