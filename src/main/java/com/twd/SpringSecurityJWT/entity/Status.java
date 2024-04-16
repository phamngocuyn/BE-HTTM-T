package com.twd.SpringSecurityJWT.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Status extends BaseEntity{

	private LocalDateTime timeIn;
	
	private LocalDateTime timeOut;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private OurUsers user;
}
