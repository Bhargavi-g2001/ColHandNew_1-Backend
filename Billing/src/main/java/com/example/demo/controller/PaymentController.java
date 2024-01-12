package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.example.demo.entity.Customerdetails;
import com.example.demo.entity.PendingCustomerdetails;
import com.example.demo.repository.CustomerDetailsRepository;
import com.example.demo.repository.PendingCustomerdetailsRepository;

import jakarta.websocket.server.PathParam;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class PaymentController {
	
//	@Autowired
//	private PendingCustomerdetailsRepository repo;
//	@PostMapping("/phone")
//	@ResponseBody
//	public ResponseEntity<List<PendingCustomerdetails>> phone(@RequestBody Map<String, String> credentials) {
//
//        String mobile = credentials.get("phoneNumber");
//        System.out.println(mobile);
//        List<PendingCustomerdetails>  ad = repo.findByMobile(mobile);
//        System.out.println(ad);
//        if (ad == null || !mobile.equals(((Customerdetails) ad).getMobile())) {
//
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//
//        }
//
//        // User is authenticated
//
//        // You can generate a JWT token or create a session here
//
//        return ResponseEntity.ok(ad);
//
//        // ok().body("{\"message\": \"Authentication successful\"}");
//
//       
//
//  }
	@Autowired
	private PendingCustomerdetailsRepository repo;

	@PostMapping("/phone")
	@ResponseBody
	public ResponseEntity<List<PendingCustomerdetails>> phone(@RequestBody Map<String, String> credentials) {
	    String mobile = credentials.get("phoneNumber");
	    System.out.println(mobile);

	    List<PendingCustomerdetails> ad = repo.findByMobile(mobile);
	    System.out.println(ad);

	    if (ad.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	    }

	    // User is authenticated

	    // You can generate a JWT token or create a session here

	    return ResponseEntity.ok(ad);
	}
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/paydetailsbill/{credentials}")
	@ResponseBody
	public ResponseEntity<List<PendingCustomerdetails>> paydetailsbill(@PathVariable int credentials) {

	        System.out.println(credentials);
            System.out.println("Hello");
	        List<PendingCustomerdetails>  ad = repo.findById(credentials);

//	        System.out.println(repo.findById(credentials));
	        System.out.println(ad);

		        return ResponseEntity.ok(ad);

	    }
	@CrossOrigin(origins="http://localhost:4200")
	 @DeleteMapping("/delete/{credentials}")
	 @ResponseBody
    public ResponseEntity<String> delete(@PathVariable Integer credentials) {

        System.out.println("user credentials" +credentials);

        repo.deleteById(credentials);

	     return ResponseEntity.ok().body("{\"message\": \"Deleted Successfully\"}");

    }



		@Autowired
		private CustomerDetailsRepository repository;

    @PostMapping("/admin/{credentials}")

    @ResponseBody

    public ResponseEntity<Optional<Customerdetails>> admin(@PathVariable Integer credentials) {

        System.out.println("Work find");

        System.out.println(credentials);

        Optional<Customerdetails> ad=repository.findById(credentials);

        System.out.println("Work");

        System.out.println(ad);

	     return ResponseEntity.ok(ad);

    }
    @CrossOrigin(origins="http://localhost:4200")
    @PutMapping("/update/{credentials}")

    @ResponseBody

    public ResponseEntity<Customerdetails> update(@PathVariable Customerdetails credentials) {

		Customerdetails ad=credentials;
		System.out.println(ad);
		repository.save(ad);
		return ResponseEntity.ok(ad);

//	repository.save(ad);
//
//        return ResponseEntity.ok(ad);	

        // ok().body("{\"message\": \"Authentication successful\"}");

       

  }
}
