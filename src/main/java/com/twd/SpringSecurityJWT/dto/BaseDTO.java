package com.twd.SpringSecurityJWT.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BaseDTO<T> {
	
	private String createdBy;
	
	private String modifiedBy;
	
	private Date createdDate;
	
	private Date modifiedDate;
	
	private List<T> listResult = new ArrayList<>();
}
