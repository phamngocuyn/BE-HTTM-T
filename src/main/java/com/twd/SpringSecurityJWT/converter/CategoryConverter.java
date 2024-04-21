package com.twd.SpringSecurityJWT.converter;

import org.springframework.stereotype.Component;

import com.twd.SpringSecurityJWT.dto.CategoryDTO;
import com.twd.SpringSecurityJWT.entity.Category;

@Component
public class CategoryConverter {

	// Chuyển đổi từ Category entity sang CategoryDTO
    public static CategoryDTO toCategoryDTO(Category category) {
        if (category == null) {
            return null;
        }
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setCategory(category.getCategory());
        dto.setCategoryUrl(category.getCategoryUrl());
        return dto;
    }

    // Chuyển đổi từ CategoryDTO sang Category entity
    public static Category toCategoryEntity(CategoryDTO categoryDTO) {
        if (categoryDTO == null) {
            return null;
        }
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        category.setCategory(categoryDTO.getCategory());
        category.setCategoryUrl(categoryDTO.getCategoryUrl());
        return category;
    }
}
