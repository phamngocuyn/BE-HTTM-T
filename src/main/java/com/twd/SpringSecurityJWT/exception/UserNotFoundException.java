package com.twd.SpringSecurityJWT.exception;


public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException(String message) {
        super(message);
    }
	
}