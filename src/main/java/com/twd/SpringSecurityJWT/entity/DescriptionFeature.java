package com.twd.SpringSecurityJWT.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DescriptionFeature extends BaseEntity{

	private String featureName;
	
	private String featureDescriptionString; 
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_detail_id")
    private productDetail productDetail;
}
// có 3 cái 1 hàng