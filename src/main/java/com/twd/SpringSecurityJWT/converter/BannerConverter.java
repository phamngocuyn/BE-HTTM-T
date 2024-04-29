package com.twd.SpringSecurityJWT.converter;

import com.twd.SpringSecurityJWT.dto.BannerDTO;
import com.twd.SpringSecurityJWT.entity.Banner;

public class BannerConverter {

	// Chuyển đổi từ Entity sang DTO
    public BannerDTO entityToDto(Banner banner) {
        BannerDTO dto = new BannerDTO();
        dto.setId(banner.getId());
        dto.setNameUrl(banner.getNameUrl());
        dto.setName(banner.getName());
        dto.setUrlBanner(banner.getUrlBanner());
        dto.setIntroduce(banner.getIntroduce());
        dto.setRelatedProducts(banner.getRelatedProducts());
        return dto;
    }

    // Chuyển đổi từ DTO sang Entity
    public Banner dtoToEntity(BannerDTO dto) {
        Banner banner = new Banner();
        banner.setId(dto.getId());
        banner.setNameUrl(dto.getNameUrl());
        banner.setName(dto.getName());
        banner.setUrlBanner(dto.getUrlBanner());
        banner.setIntroduce(dto.getIntroduce());
        banner.setRelatedProducts(dto.getRelatedProducts());
        return banner;
    }
}
