package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OtpRequest;
import com.example.demo.dto.OtpResponseDto;
import com.example.demo.dto.OtpValidationRequest;
import com.example.demo.service.SmsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/otp")
@Slf4j
@CrossOrigin(origins ="http://localhost:4200")
public class OtpController {

	
	@Autowired
	private SmsService smsService;
	private long systemOtp;
	
	@GetMapping("/process")
	public String processSMS() {
		return "SMS sent";
	}
	@PostMapping("/send-otp")
	public OtpResponseDto sendOtp(@RequestBody OtpRequest otpRequest) {
		log.info("inside sendOtp :: "+otpRequest.getPhoneNumber());
		OtpResponseDto otpDetails = smsService.sendSMS(otpRequest);
		System.out.println(otpDetails.getOtp());
		return otpDetails;
		
}
	@PostMapping("/validate-otp")
    public String validateOtp(@RequestBody OtpValidationRequest otpValidationRequest) {
		log.info("inside validateOtp :: "+otpValidationRequest.getUsername()+" "+otpValidationRequest.getOtpNumber());
		return smsService.validateOtp(otpValidationRequest,this.systemOtp);
    }

	
}