package com.twd.SpringSecurityJWT.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.twd.SpringSecurityJWT.converter.ProductConverter;
import com.twd.SpringSecurityJWT.dto.ProductDTO;
import com.twd.SpringSecurityJWT.entity.Product;
import com.twd.SpringSecurityJWT.service.IProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	@Autowired
	private IProductService productService;
	
	//lấy danh sách tất cả các sản phẩm
	@GetMapping("/public/products")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
	
	// lấy danh sách theo category
	@GetMapping("/public/product-categorys/{categoryCode}")
    public ResponseEntity<List<ProductDTO>> getProductsByCategoryCode(@PathVariable String categoryCode) {
        List<ProductDTO> products = productService.getProductsByCategoryCode(categoryCode);
        return ResponseEntity.ok(products);
    }
	
	// lấy sanh sách sản phẩm theo brand
	@GetMapping("/public/product-brands/{brandName}")
    public ResponseEntity<List<ProductDTO>> getProductsByBrandName(@PathVariable String brandName) {
        List<ProductDTO> products = productService.getProductsByBrandName(brandName);
        return ResponseEntity.ok(products);
    }
	
	// Tìm kiếm sản phẩm (header)
	@GetMapping("/public/search")
    public ResponseEntity<List<ProductDTO>> searchProducts(@RequestParam(required = false) String name,
                                                           @RequestParam(required = false) Double price) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(name);
        productDTO.setPrice(price);
        List<ProductDTO> products = productService.searchProducts(productDTO);
        return ResponseEntity.ok(products);
    }
	
	// Lấy ra name Layout
	@GetMapping("/public/{categoryId}/layout-names")
    public List<String> getLayoutNamesByCategoryId(@PathVariable Long categoryId) {
        return productService.getLayoutNamesByCategoryId(categoryId);
    }
}
