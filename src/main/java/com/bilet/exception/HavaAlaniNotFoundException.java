package com.bilet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HavaAlaniNotFoundException  extends RuntimeException {

	public HavaAlaniNotFoundException(String error) {
		super(error);
	}
	

}
