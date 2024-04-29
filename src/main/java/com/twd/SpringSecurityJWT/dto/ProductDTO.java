package com.twd.SpringSecurityJWT.dto;

import lombok.Data;

@Data
public class ProductDTO {

	private Integer id;
    
    private String name;
    
    private String url;
    
    private Double price;
    
    private int quantity;
    
    private Double totalStar;
}
