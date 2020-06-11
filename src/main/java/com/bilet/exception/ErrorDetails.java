package com.bilet.exception;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDetails {
	private Date timeStamp;
	private String messages;
	private String details;
	
	public ErrorDetails(Date timeStamp, String messages, String details) {
		super();
		this.timeStamp = timeStamp;
		this.messages = messages;
		this.details = details;
	}
	
	
	

}
