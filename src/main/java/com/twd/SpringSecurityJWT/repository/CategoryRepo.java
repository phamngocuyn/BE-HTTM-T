package com.twd.SpringSecurityJWT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twd.SpringSecurityJWT.entity.Category;


@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
