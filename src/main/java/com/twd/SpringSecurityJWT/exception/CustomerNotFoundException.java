package com.twd.SpringSecurityJWT.exception;

public class CustomerNotFoundException extends RuntimeException{

	public CustomerNotFoundException(String message) {
        super(message);
    }
	
}
