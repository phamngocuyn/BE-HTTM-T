package com.twd.SpringSecurityJWT.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CustomerDTO {
	private String address;
	
	private String avatar;
	
	private Date dateOfBirth;
	
	private String fullName;
	
	private String phoneNumber;
	
	private String gender;
	
	private String status;
}
