package com.twd.SpringSecurityJWT.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twd.SpringSecurityJWT.converter.ProductConverter;
import com.twd.SpringSecurityJWT.dto.ProductDTO;
import com.twd.SpringSecurityJWT.entity.Product;
import com.twd.SpringSecurityJWT.repository.ProductRepo;
import com.twd.SpringSecurityJWT.service.IProductService;

@Service
public class ProductService implements IProductService{

	@Autowired
	private ProductRepo productRepo;

	// list product category
	@Override
	public List<ProductDTO> getProductsByCategoryCode(String categoryCode) {
		return productRepo.findByCategoryCode(categoryCode)
                .stream()
                .map(ProductConverter::toProductDTO)
                .collect(Collectors.toList());
	}

	// list product brand
	@Override
	public List<ProductDTO> getProductsByBrandName(String brandName) {
		return productRepo.findByBrandName(brandName)
                .stream()
                .map(ProductConverter::toProductDTO)
                .collect(Collectors.toList());
	}

	//search product
	@Override
	public List<ProductDTO> searchProducts(ProductDTO productDTO) {
		List<Product> products = productRepo.searchProducts(
	            productDTO.getName(),
	            productDTO.getPrice());
	        return products.stream()
	                       .map(ProductConverter::toProductDTO)
	                       .collect(Collectors.toList());
	}

	// lấy danh sách sản phẩm
	@Override
	public List<ProductDTO> getAllProducts() {
		List<Product> products = productRepo.findAll();
        return products.stream().map(ProductConverter::toProductDTO).collect(Collectors.toList());
	}

	@Override
	public List<String> getLayoutNamesByCategoryId(Long categoryId) {
		return productRepo.findAllLayoutNamesByCategoryId(categoryId);
	}

}
