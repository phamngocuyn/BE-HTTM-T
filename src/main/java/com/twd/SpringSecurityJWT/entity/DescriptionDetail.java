package com.twd.SpringSecurityJWT.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class DescriptionDetail extends BaseEntity{

	private String intro;
	
	private String maintenance;
	
	private String origin;
	
	private String totalProduct;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_detail_id")
    private productDetail productDetail;
}
