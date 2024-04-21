package com.twd.SpringSecurityJWT.dto;

import lombok.Data;

@Data
public class OrderDTO {

	private String email;
	
	private String firstName;
	
	private String lastName;
	
	private String country;
	
	private String company;
	
	private String adress;
	
	private String city;
	
	private String phoneNumber;
	
	private String potalCode;
	
	private String typeReceive;
	
	private String shipMethod;
	
	private String payMethod;
	
	private Float totalMoney;
}
