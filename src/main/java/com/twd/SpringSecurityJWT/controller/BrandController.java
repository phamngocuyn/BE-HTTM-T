package com.twd.SpringSecurityJWT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twd.SpringSecurityJWT.dto.BrandDTO;
import com.twd.SpringSecurityJWT.service.IBrandService;

@RestController
@CrossOrigin
public class BrandController {

	@Autowired
	private IBrandService brandService;
	
	@GetMapping("/public/brand")
    public ResponseEntity<List<BrandDTO>> getAllBrands() {
        List<BrandDTO> brands = brandService.findAllBrands();
        return ResponseEntity.ok(brands);
    }
}
