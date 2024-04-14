package com.twd.SpringSecurityJWT.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class userDetail extends BaseEntity {

    private String name;
    private String address;
    private String gender;
    private String phoneNumber;
    
    private Date dateOfBirth;
    private String nationality;
    
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private OurUsers user;
}
