package com.twd.SpringSecurityJWT.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Position extends BaseEntity{
	
	private String positionName;
	
	@OneToMany(mappedBy = "position", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Employee> employees;
}
