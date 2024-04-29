package com.twd.SpringSecurityJWT.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twd.SpringSecurityJWT.converter.BrandConverter;
import com.twd.SpringSecurityJWT.dto.BrandDTO;
import com.twd.SpringSecurityJWT.entity.Brand;
import com.twd.SpringSecurityJWT.repository.BrandRepo;
import com.twd.SpringSecurityJWT.service.IBrandService;

@Service
public class BrandService implements IBrandService{

	@Autowired
	private BrandRepo brandRepo;

	@Override
	public List<BrandDTO> findAllBrands() {
		List<Brand> brands = brandRepo.findAll();
        return brands.stream()
                     .map(BrandConverter::toBrandDTO)
                     .collect(Collectors.toList());
	}
	
	
}
