package com.twd.SpringSecurityJWT.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twd.SpringSecurityJWT.converter.CategoryConverter;
import com.twd.SpringSecurityJWT.dto.CategoryDTO;
import com.twd.SpringSecurityJWT.repository.CategoryRepo;
import com.twd.SpringSecurityJWT.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService{

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public List<CategoryDTO> getAllCategories() {
		return categoryRepo.findAll().stream()
                .map(CategoryConverter::toCategoryDTO)
                .collect(Collectors.toList());
	}
	
}
