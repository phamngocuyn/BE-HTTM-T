package com.twd.SpringSecurityJWT.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DescriptionCharacteristic extends BaseEntity{

	private String urlImg;
	
	private String title;
	
	private String content;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_detail_id")
    private productDetail productDetail;
}
