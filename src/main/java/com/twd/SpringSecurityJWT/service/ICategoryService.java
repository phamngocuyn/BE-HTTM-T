package com.twd.SpringSecurityJWT.service;

import java.util.List;

import com.twd.SpringSecurityJWT.dto.CategoryDTO;

public interface ICategoryService {

	List<CategoryDTO> getAllCategories();
}
