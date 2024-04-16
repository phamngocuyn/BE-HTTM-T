package com.twd.SpringSecurityJWT.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Employee extends BaseEntity{
	
	private String address;
	
	private String avatar;
	
	private Date dateOfBirth;
	
	private String fullName;
	
	private String phoneNumber;
	
	private String gender;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private OurUsers user;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    private Position position;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Order> orders;
}
