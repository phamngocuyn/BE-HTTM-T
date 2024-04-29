package com.twd.SpringSecurityJWT.converter;

import com.twd.SpringSecurityJWT.dto.ProductDTO;
import com.twd.SpringSecurityJWT.entity.Product;
import com.twd.SpringSecurityJWT.entity.ProductStar;
import java.util.*;

public class ProductConverter {

    // Làm tròn đến nửa sao
    private static double roundToHalf(double value) {
        return Math.round(value * 2) / 2.0;
    }

    public static ProductDTO toProductDTO(Product product) {
        if (product == null) {
            return null;
        }
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setUrl(product.getUrl());
        dto.setPrice(Double.valueOf(product.getPrice()));
        dto.setQuantity(product.getQuantity());

        // Tính giá trị trung bình sao
        List<ProductStar> stars = product.getStars();
        if (stars != null && !stars.isEmpty()) {
            double average = stars.stream()
                                  .mapToDouble(ProductStar::getCount)
                                  .average()
                                  .orElse(0.0);  // Nếu không có sao thì trả về 0
            dto.setTotalStar(roundToHalf(average));  // Làm tròn đến nửa sao
        } else {
            dto.setTotalStar(0.0);  // Nếu danh sách sao rỗng
        }
        return dto;
    }

    // Chuyển đổi từ ProductDTO sang Product entity
    public static Product toProductEntity(ProductDTO productDTO) {
        if (productDTO == null) {
            return null;
        }
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setUrl(productDTO.getUrl());
        product.setPrice(productDTO.getPrice().floatValue());
        product.setQuantity(productDTO.getQuantity());
        return product;
    }
}
