package com.twd.SpringSecurityJWT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twd.SpringSecurityJWT.entity.Brand;

@Repository
public interface BrandRepo extends JpaRepository<Brand, Integer>{

}
