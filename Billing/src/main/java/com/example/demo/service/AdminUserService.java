package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.adminlogin;
import com.example.demo.repository.AdminRepository;

@Service
public class AdminUserService {
	@Autowired
	private AdminRepository adminRepository;
	
	public boolean authenticate(String username,String password) {
		adminlogin admin=adminRepository.findByUsername(username);
		if(admin != null && admin.getPassword().equals(password)) {
		return true;
	}
		return false;
		
	}

}
