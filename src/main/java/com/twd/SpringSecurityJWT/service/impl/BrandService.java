package com.twd.SpringSecurityJWT.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twd.SpringSecurityJWT.repository.BrandRepo;
import com.twd.SpringSecurityJWT.service.IBrandService;

@Service
public class BrandService implements IBrandService{

	@Autowired
	private BrandRepo brandRepo;
	
	
}
