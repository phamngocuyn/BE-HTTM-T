package com.twd.SpringSecurityJWT.entity;

import java.util.*;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product extends BaseEntity{
	
    private String name;
    
    private String url;
    
    private Float price;
    
    private int quantity;
    
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
    
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false) 
    private Category category;
    
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetails;
    
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<productComment> comments = new ArrayList<>();
    
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private productDetail detail;
    
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductStar> stars;
}
