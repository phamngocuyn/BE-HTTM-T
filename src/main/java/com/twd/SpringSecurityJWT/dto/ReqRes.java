package com.twd.SpringSecurityJWT.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.twd.SpringSecurityJWT.entity.OurUsers;
import com.twd.SpringSecurityJWT.entity.Product;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReqRes {

    private int statusCode;
    
    private String error;
    
    private String message;
    
    private String token;
    
    private String refreshToken;
    
    private String expirationTime;
    
    @NotBlank(message = "Tên không được để trống")
    @Size(min = 10, max = 50, message = "Tên phải có độ dài từ 10 đến 50 ký tự")
	@Pattern(regexp = "^\\p{L}+(?:[\\s]\\p{L}+)*$", message = "Tên chỉ được chứa chữ cái và dấu cách, không được có hai dấu cách liên tiếp")
    private String name;
    
    @NotBlank(message = "Email không được để trống")
    private String email;
    
    @NotBlank(message = "Quyền không được để trống")
	@Pattern(regexp = "USER|ADMIN", message = "Quyền không hợp lệ (USER OR ADMIN)")
    private String role;
    
    @NotBlank(message = "Password không được để trống")
    @Size(min = 8, message = "Password phải có ít nhất 8 kí tự")
    private String password;
    
    private List<Product> products;
    
    private OurUsers ourUsers;
}
