package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customerdetails;
import com.example.demo.repository.CustomerDetailsRepository;


@RestController
public class CustomerDetailsController {
	@Autowired
	private CustomerDetailsRepository customerRepository;
	   @CrossOrigin(origins = "http://localhost:4200")
	    @ResponseBody
   
	    
	  @GetMapping("/all")

	    public List<Customerdetails> getAllCustomers(){
		  return customerRepository.findAll();
	  }
}
