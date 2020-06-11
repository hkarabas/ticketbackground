package com.bilet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HavaYoluNotFoundException extends RuntimeException {
	public HavaYoluNotFoundException(String exception){
		super(exception);
	}
	
}
