package com.twd.SpringSecurityJWT.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class ProductStar extends BaseEntity{

	private Double count;
	
	@ManyToOne
    @JoinColumn(name = "product_id") 
    private Product product;
}
