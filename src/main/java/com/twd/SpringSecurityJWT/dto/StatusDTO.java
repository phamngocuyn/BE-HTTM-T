package com.twd.SpringSecurityJWT.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class StatusDTO {
	
	private LocalDateTime timeIn;
	
	private LocalDateTime timeOut;
}
