package com.twd.SpringSecurityJWT.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DescriptionInstruct extends BaseEntity{

	private String instruct;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_detail_id")
    private productDetail productDetail;
}

//Hướng dẫn