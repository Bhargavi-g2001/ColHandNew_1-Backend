package com.example.demo.entity;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Component
@Table(name="CustomerDetails")
public class Customerdetails {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int  customer_id;
	private String name;
	private String mobile;
	private String email;
	private Date duedate;
	private String status;
	private BigDecimal previousbalance;
	private BigDecimal currentbalance;
	private BigDecimal outbalance;
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
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
	public BigDecimal getPreviousbalance() {
		return previousbalance;
	}
	public void setPreviousbalance(BigDecimal previousbalance) {
		this.previousbalance = previousbalance;
	}
	public BigDecimal getCurrentbalance() {
		return currentbalance;
	}
	public void setCurrentbalance(BigDecimal currentbalance) {
		this.currentbalance = currentbalance;
	}
	public BigDecimal getOutbalance() {
		return outbalance;
	}
	public void setOutbalance(BigDecimal outbalance) {
		this.outbalance = outbalance;
	}
	@Override
	public String toString() {
		return "Customerdetails [customer_id=" + customer_id + ", name=" + name + ", mobile=" + mobile + ", email="
				+ email + ", duedate=" + duedate + ", status=" + status + ", previousbalance=" + previousbalance
				+ ", currentbalance=" + currentbalance + ", outbalance=" + outbalance + "]";
	}
	
	
	

}
