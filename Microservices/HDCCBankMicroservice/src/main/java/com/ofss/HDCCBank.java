package com.ofss;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "HDCC_CUSTOMERS",schema="hd")
public class HDCCBank {
	@Id
	private Long accountNo;
	private String customerName;
	private String permanentAddress;
	private String currentAddress;
	private long phoneNo;
	private String email;
	private String occupation;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date dob;
	private String panNumber;
	private String aadhaarNumber;
	private String passportNumber;
	private String ekyc;
	private double accountBalance;
	private String photo;
	
	public HDCCBank() {
		// TODO Auto-generated constructor stub
	}
	public HDCCBank(Long accountNo, String customerName, String permanentAddress, String currentAddress, long phoneNo,
			String email, String occupation, Date dob, String panNumber, String aadhaarNumber,
			String passportNumber, String ekyc, double accountBalance, String photo) {
		super();
		this.accountNo = accountNo;
		this.customerName = customerName;
		this.permanentAddress = permanentAddress;
		this.currentAddress = currentAddress;
		this.phoneNo = phoneNo;
		this.email = email;
		this.occupation = occupation;
		this.dob= dob;
		this.panNumber = panNumber;
		this.aadhaarNumber = aadhaarNumber;
		this.passportNumber = passportNumber;
		this.ekyc = ekyc;
		this.accountBalance = accountBalance;
		this.photo = photo;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getCurrentAddress() {
		return currentAddress;
	}
	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public Date getDob() {
		return dob;
	}
	public void setDOB(Date dob) {
		this.dob = dob;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPancardNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getAadhaarNumber() {
		return aadhaarNumber;
	}
	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public String getEkyc() {
		return ekyc;
	}
	public void setEkyc(String ekyc) {
		this.ekyc = ekyc;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	

}
