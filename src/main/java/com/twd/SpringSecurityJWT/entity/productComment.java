package com.twd.SpringSecurityJWT.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class productComment {

	private int id;
	
	private String comment;
	
	private String urlImg;
	
	private String status;
}
