package com.twd.SpringSecurityJWT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.twd.SpringSecurityJWT.service.IBrandService;

@RestController
@CrossOrigin
public class BrandController {

	@Autowired
	private IBrandService brandService;
}
