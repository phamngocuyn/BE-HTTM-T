package com.twd.SpringSecurityJWT.dto;

import lombok.Data;

@Data
public class BannerDTO extends BaseDTO<BannerDTO>{

	private int id;
	
	private String nameUrl; //name
	
	private String Name;
	
	private String urlBanner;
	
	private String introduce;
	
	private String relatedProducts;
}
