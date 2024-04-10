package com.twd.SpringSecurityJWT.exception;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.twd.SpringSecurityJWT.error.ErrorResponse;
import com.twd.SpringSecurityJWT.exception.EmailExistsException;


@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = RuntimeException.class)
	ResponseEntity<String> handlingRuntimeException (RuntimeException exception){
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	ResponseEntity<String> handlingValidation(MethodArgumentNotValidException exception){
		return ResponseEntity.badRequest().body(exception.getFieldError().getDefaultMessage());
	}
	
	@ExceptionHandler(EmailExistsException.class)
	public ResponseEntity<ErrorResponse> handleEmailExistsException(EmailExistsException ex) {
	    ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Email này đã tồn tại");
	    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
//	    Map<String, Object> body = new LinkedHashMap<>();
//	    body.put("timestamp", LocalDateTime.now());
//	    body.put("status", HttpStatus.BAD_REQUEST.value());
//
//	    // Lấy các lỗi
//	    List<String> errors = ex.getBindingResult()
//	            .getFieldErrors()
//	            .stream()
//	            .map(FieldError::getDefaultMessage)
//	            .collect(Collectors.toList());
//
//	    body.put("errors", errors);
//
//	    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
//	}

	
}