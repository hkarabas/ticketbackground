package com.bilet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class KullaniciNotFoundException extends RuntimeException {

	public KullaniciNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	

}
