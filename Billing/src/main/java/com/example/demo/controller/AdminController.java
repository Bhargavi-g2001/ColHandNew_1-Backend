package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.adminlogin;
import com.example.demo.entity.message;
import com.example.demo.repository.AdminRepository;
import com.example.demo.service.AdminUserService;
@CrossOrigin
@RestController
public class AdminController {
	
//@Autowired
//private AdminUserService adminservice;
@Autowired 
private AdminRepository adminrepo;

//@RequestMapping("/adminss")
@ResponseBody
//public ResponseEntity<String> admin(@RequestParam String username,@RequestParam String password)
//{
//	if(adminservice.authenticate(username, password)) {
//		return ResponseEntity.ok("login successful");
//	}else {
//		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid credentials");
//	}
//}

@PostMapping("/checksignin")
public message checksignin(@RequestBody adminlogin credential) {
	message m=new message();
	System.out.println(credential.getUsername()+" "+credential.getPassword());
	adminlogin l=adminrepo.findByUsername(credential.getUsername());
	
	if(l!=null) {
		System.out.println(l.getUsername()+" "+l.getPassword());
		if(l.getUsername().equals(credential.getUsername())&&l.getPassword().equals(credential.getPassword())) {
			m.setMessage("Login successful");
			m.setStatus(true);
		}
		else {
			m.setMessage("User name password incorrect");
			m.setStatus(false);
		}
	}
	else {
		m.setMessage("AdminUser not available");
		m.setStatus(false);
	}
	return m;
}



}
