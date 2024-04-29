package com.twd.SpringSecurityJWT.repository;

import com.twd.SpringSecurityJWT.entity.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
	
	@Query("SELECT p FROM Product p WHERE p.category.category = :categoryCode")
    List<Product> findByCategoryCode(@Param("categoryCode") String categoryCode);
	
	@Query("SELECT p FROM Product p WHERE p.brand.brand = :brandName")
    List<Product> findByBrandName(@Param("brandName") String brandName);
	
	@Query("SELECT p FROM Product p WHERE " +
	           "(:name IS NULL OR p.name LIKE %:name%) " +
	           "AND (:price IS NULL OR p.price = :price) ")
	    List<Product> searchProducts(
	            @Param("name") String name,
	            @Param("price") Double price);
	
	@Query("SELECT pl.name FROM Product p " +
	           "JOIN p.detail d " +
	           "JOIN d.layouts pl " +
	           "WHERE p.category.id = :categoryId")
	    List<String> findAllLayoutNamesByCategoryId(@Param("categoryId") Long categoryId);
}
