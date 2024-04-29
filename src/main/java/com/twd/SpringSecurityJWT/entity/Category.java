package com.twd.SpringSecurityJWT.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Category extends BaseEntity{
	
	private String name;
	
	private String category;
	
	private String categoryUrl;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "banner_id", referencedColumnName = "id")
    private Banner banner;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Product> products;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Brand> brands;
}
