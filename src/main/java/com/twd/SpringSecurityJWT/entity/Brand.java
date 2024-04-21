package com.twd.SpringSecurityJWT.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Brand extends BaseEntity{
	
	private String brand;
	
	private String brandUrl;
	
	@OneToOne(mappedBy = "brand")
    private Banner banner;
	
	@OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private Set<Product> products;
	
	@ManyToOne
    private Category category;
}
