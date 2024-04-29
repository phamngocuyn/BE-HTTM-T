package com.twd.SpringSecurityJWT.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Banner extends BaseEntity{
	
	private String nameUrl; //name
	
	private String Name;
	
	private String urlBanner;
	
	private String introduce;
	
	private String relatedProducts;
	
	@OneToOne(mappedBy = "banner")
    private Category category;
	
	@OneToOne(mappedBy = "banner")
    private Brand brand;
}
