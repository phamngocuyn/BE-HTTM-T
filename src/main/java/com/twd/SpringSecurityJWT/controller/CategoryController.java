package com.twd.SpringSecurityJWT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twd.SpringSecurityJWT.dto.CategoryDTO;
import com.twd.SpringSecurityJWT.service.ICategoryService;


@CrossOrigin
@RestController
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;
	
	@GetMapping("/user/category")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<CategoryDTO> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }
	
}
