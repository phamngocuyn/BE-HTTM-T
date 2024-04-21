package com.twd.SpringSecurityJWT.converter;

import com.twd.SpringSecurityJWT.dto.BrandDTO;
import com.twd.SpringSecurityJWT.entity.Brand;

public class BrandConverter {

	// Chuyển đổi từ Brand entity sang BrandDTO
    public static BrandDTO toBrandDTO(Brand brand) {
        if (brand == null) {
            return null;
        }
        BrandDTO dto = new BrandDTO();
        dto.setId(brand.getId());
        dto.setBrand(brand.getBrand());
        dto.setBrandUrl(brand.getBrandUrl());
        return dto;
    }

    // Chuyển đổi từ BrandDTO sang Brand entity
    public static Brand toBrandEntity(BrandDTO brandDTO) {
        if (brandDTO == null) {
            return null;
        }
        Brand brand = new Brand();
        brand.setId(brandDTO.getId());
        brand.setBrand(brandDTO.getBrand());
        brand.setBrandUrl(brandDTO.getBrandUrl());
        return brand;
    }
}
