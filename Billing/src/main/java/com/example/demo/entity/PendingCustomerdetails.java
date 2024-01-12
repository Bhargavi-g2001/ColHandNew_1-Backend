package com.example.demo.entity;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@Component
public class PendingCustomerdetails {
	@Id
	@GeneratedValue
	private int  id;
	private String name;
	
	private String mobile;
	private String email;
	private Date duedate;
	
	private String status;
	private int days;
	private BigDecimal currentbalance;
	private BigDecimal previousbalance;
	private BigDecimal outbalance;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDuedate() {
		return duedate;
	}
	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public BigDecimal getCurrentbalance() {
		return currentbalance;
	}
	public void setCurrentbalance(BigDecimal currentbalance) {
		this.currentbalance = currentbalance;
	}
	public BigDecimal getPreviousbalance() {
		return previousbalance;
	}
	public void setPreviousbalance(BigDecimal previousbalance) {
		this.previousbalance = previousbalance;
	}
	public BigDecimal getOutbalance() {
		return outbalance;
	}
	public void setOutbalance(BigDecimal outbalance) {
		this.outbalance = outbalance;
	}
	@Override
	public String toString() {
		return "PendingCustomerdetails [id=" + id + ", name=" + name + ", mobile=" + mobile + ", email=" + email
				+ ", duedate=" + duedate + ", status=" + status + ", days=" + days + ", currentbalance="
				+ currentbalance + ", previousbalance=" + previousbalance + ", outbalance=" + outbalance + "]";
	}
	
	
	

}
