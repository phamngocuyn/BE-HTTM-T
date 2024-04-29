package com.twd.SpringSecurityJWT.service;

import java.util.List;

import com.twd.SpringSecurityJWT.dto.ProductDTO;
import com.twd.SpringSecurityJWT.entity.Product;

public interface IProductService {
	
	List<ProductDTO> getAllProducts();
	
	List<ProductDTO> getProductsByCategoryCode(String categoryCode);
	
	List<ProductDTO> getProductsByBrandName(String brandName);
	
	List<ProductDTO> searchProducts(ProductDTO productDTO);
	
	List<String> getLayoutNamesByCategoryId(Long categoryId);
}
