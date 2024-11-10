package com.jsp.pharma.requestdtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public class AdminRequest {
	
	@Email(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$",message = "Invalid Email Id")
	private String email;
	
	@Pattern(regexp = "^[6-9]\\d{9}$",message = "Invalid Mobile Number,The Mobile Number Should Contains 10 digits")
	private String phoneNumber;
	
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W])[\\w\\W]{8,12}$",
			message = "Password Should Contain atleast one uppercase letter ,"
					+ "lower case letter , special character with minimum length 8 characters to maximum length 12 characters")
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
