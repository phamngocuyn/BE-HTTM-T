package com.twd.SpringSecurityJWT.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class DescriptionSpecifications extends BaseEntity{

	private String specName;
	
	private String specValue;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_detail_id")
    private productDetail productDetail;
}

// thông số kĩ thuật