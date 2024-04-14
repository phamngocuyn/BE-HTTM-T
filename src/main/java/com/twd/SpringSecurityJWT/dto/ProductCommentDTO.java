package com.twd.SpringSecurityJWT.dto;

import lombok.Data;

@Data
public class ProductCommentDTO {

	private int id;
	
	private String comment;
	
	private String urlImg;
	
	private String status;
}
