package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.PendingCustomerdetails;
import com.example.demo.entity.emailmessage;
import com.example.demo.repository.PendingCustomerdetailsRepository;
import com.example.demo.service.PendingCustomerService;

import jakarta.mail.MessagingException;


@RestController
public class PendingCustomerController {
	@Autowired
	PendingCustomerdetailsRepository pendingCustomerdetailsRepository;
	@Autowired
	PendingCustomerService pendingCustomerService;
	@Autowired
	EmailService emailService;
	
	
	   @CrossOrigin(origins = "http://localhost:4200")
	    @ResponseBody
   
	  @GetMapping("/pending")

	    public List<PendingCustomerdetails> getpendingCustomers(){
		  return pendingCustomerdetailsRepository.findAll();
		 
		  
				  }
//	   @CrossOrigin(origins = "http://localhost:4200")
//	   @PostMapping("/email/{customerId}")
//	    public ResponseEntity<emailmessage> sendEmail(@PathVariable int customerId) throws MessagingException {
//	        Optional<PendingCustomerdetails> customer = pendingCustomerService.getCustomerById(customerId);
//			
//	        if (customer == null) {
//	            //return ResponseEntity.badRequest().body("Customer not found with ID: " + customerId);
//	            return new ResponseEntity<emailmessage>(new emailmessage("Customer not found with ID: " + customerId),HttpStatus.OK);
//	        }
//
//	 
//
//	        // Send email using emailService -body of mail
//	        String emailContent = "Dear Customer, Your Postpaid plan will expire on " +customer.get().getDuedate()+ " Once plan expired,your services will be terminated.To Continue services,click the below link and pay";
//	        emailService.sendEmail(customer.get().getEmail(),"Subject: Notification Message",emailContent);
//
//	 
//
//	        //return ResponseEntity.ok("Email sent successfully to customer with ID: " + customerId);
//	        return new ResponseEntity<emailmessage>(new emailmessage("Email sent successfully to customer with ID:"+ customerId),HttpStatus.OK);
//	    }

	   //*******for payment successful mail*******
	    @CrossOrigin(origins = "http://localhost:4200")
	    @PostMapping("/send-email/{customerId}")
	    public ResponseEntity<emailmessage> send1(@PathVariable int customerId) throws MessagingException {
	    	System.out.println(customerId+"hello");
	        List<PendingCustomerdetails> customer = pendingCustomerService.getCustomerById(customerId);
			
	        if (customer == null) {
	            //return ResponseEntity.badRequest().body("Customer not found with ID: " + customerId);
	            return new ResponseEntity<emailmessage>(new emailmessage("Customer not found with ID: " + customerId),HttpStatus.OK);
	        }

	 
	        System.out.println("hii");
	        System.out.println(customer+"it");
	        System.out.println(customer.get(0)+"this");
	        System.out.println(customer.get(0).getId()+"me");
	        // Send email using emailService -body of mail
	        String emailContent = "Dear "+customer.get(0).getName()+ " Your Postpaid Recharge of Rs."+customer.get(0).getOutbalance() + " is successfully Completed.Enjoy  Unlimited Services with Propay.<br>";
	        emailContent += "<br>Thanks, <br>Propay";
	        System.out.println(emailContent);
	        emailService.sendEmail(customer.get(0).getEmail(),"Subject:Payment Successful",emailContent);

	 

	        //return ResponseEntity.ok("Email sent successfully to customer with ID: " + customerId);
	        return new ResponseEntity<emailmessage>(new emailmessage("Email sent successfully to customer with ID:"+ customerId),HttpStatus.OK);
	    }

	   
	  
	    //mail to  upi pay......
	    @CrossOrigin(origins = "http://localhost:4200")
	    @PostMapping("/sendemail/{customerId}")
	    public ResponseEntity<emailmessage> send2(@PathVariable int customerId) throws MessagingException {
	    	System.out.println(customerId+"hello");
	        List<PendingCustomerdetails> customer = pendingCustomerService.getCustomerById(customerId);
			
	        if (customer == null) {
	            //return ResponseEntity.badRequest().body("Customer not found with ID: " + customerId);
	            return new ResponseEntity<emailmessage>(new emailmessage("Customer not found with ID: " + customerId),HttpStatus.OK);
	        }

	 
	        System.out.println("hii");
	        System.out.println(customer+"it");
	        System.out.println(customer.get(0)+"this");
	        System.out.println(customer.get(0).getId()+"me");
	        // Send email using emailService -body of mail
	        String emailContent = "Dear "+customer.get(0).getName()+ " Your Postpaid Recharge of Rs."+customer.get(0).getOutbalance() + " is successfully Completed.Enjoy  Unlimited Services with Propay.<br>";
	        emailContent += "<br>Thanks, <br>Propay";
	        System.out.println(emailContent);
	        emailService.sendEmail(customer.get(0).getEmail(),"Subject: Payment Succesful",emailContent);

	 

	        //return ResponseEntity.ok("Email sent successfully to customer with ID: " + customerId);
	        return new ResponseEntity<emailmessage>(new emailmessage("Email sent successfully to customer with ID:"+ customerId),HttpStatus.OK);
	    }
//for issues
	    @CrossOrigin(origins = "http://localhost:4200")
	    @PostMapping("/sendemailtoissues/{customerId}")
	    public ResponseEntity<emailmessage> send3(@PathVariable int customerId,@RequestBody String issue) throws MessagingException {
	    	System.out.println(customerId+"hello");
	    	System.out.println(issue);
	        List<PendingCustomerdetails> customer = pendingCustomerService.getCustomerById(customerId);
			
	        if (customer == null) {
	            //return ResponseEntity.badRequest().body("Customer not found with ID: " + customerId);
	            return new ResponseEntity<emailmessage>(new emailmessage("Customer not found with ID: " + customerId),HttpStatus.OK);
	        }

	 
	        System.out.println("hii");
	        System.out.println(customer+"it");
	        System.out.println(customer.get(0)+"this");
	        System.out.println(customer.get(0).getId()+"me");
	        // Send email using emailService -body of mail
	        String emailContent = "Dear Customer, Your "+ issue + " will be resolved as soon as Possible.Our Team is Working on resolving your issue and you will receive notification once resolved. " ;
	        emailContent += "<br>Thanks, <br>Propay";
	        System.out.println(emailContent);
	        emailService.sendEmail(customer.get(0).getEmail(),"Subject: Notification from Propay",emailContent);

	 

	        //return ResponseEntity.ok("Email sent successfully to customer with ID: " + customerId);
	        return new ResponseEntity<emailmessage>(new emailmessage("Email sent successfully to customer with ID:"+ customerId),HttpStatus.OK);
	    }

	   
}