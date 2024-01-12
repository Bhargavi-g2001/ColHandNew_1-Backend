package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CustomerSupportLogin;
import com.example.demo.entity.message;
import com.example.demo.entity.message1;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.CustomerSupportRepository;

@CrossOrigin
@RestController
public class CustomerSupportController {

	@Autowired 
	private CustomerSupportRepository customerSupportrepo;
	
	@PostMapping("/checksign")
	public message1 checksignin(@RequestBody CustomerSupportLogin credential) {
		message1 m1=new message1();
		System.out.println(credential.getUsername()+" "+credential.getPassword());
		CustomerSupportLogin l=customerSupportrepo.findByUsername(credential.getUsername());
		
		if(l!=null) {
			System.out.println(l.getUsername()+" "+l.getPassword());
			if(l.getUsername().equals(credential.getUsername())&&l.getPassword().equals(credential.getPassword())) {
				m1.setMessage("CustomerSupportLogin successful");
				m1.setStatus(true);
			}
			else {
				m1.setMessage("Username/password incorrect");
				m1.setStatus(false);
			}
		}
		else {
			m1.setMessage("CustomerSupportUser not available");
			m1.setStatus(false);
		}
		return m1;
	}
	
}
