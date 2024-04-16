package com.twd.SpringSecurityJWT.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "orders") 
public class Order extends BaseEntity{

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
	
	@Enumerated(EnumType.STRING)
    private StatusOrder status;
	
	@ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetails;
}
