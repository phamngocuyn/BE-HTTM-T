package com.twd.SpringSecurityJWT.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Customer extends BaseEntity{
	
	private String address;
	
	private String avatar;
	
	private Date dateOfBirth;
	
	private String fullName;
	
	private String phoneNumber;
	
	private String gender;
	
	private String status;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private OurUsers user;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<productComment> comments;
}
