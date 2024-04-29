package com.twd.SpringSecurityJWT.service;

import java.util.List;

import com.twd.SpringSecurityJWT.dto.BrandDTO;

public interface IBrandService {

	List<BrandDTO> findAllBrands();
}
