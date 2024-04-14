package com.twd.SpringSecurityJWT.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class productListImg extends BaseEntity{
	
	private String urlImg;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detail_id")
    private productDetail detail;
}
