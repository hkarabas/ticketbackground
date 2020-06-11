package com.bilet.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	

	  @ExceptionHandler(HavaYoluNotFoundException.class)
	  public final ResponseEntity<ErrorDetails> handleHavaYoluNotFoundException(HavaYoluNotFoundException ex, WebRequest request) {
	    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	  }
	  
	  @ExceptionHandler(HavaAlaniNotFoundException.class)
	  public final ResponseEntity<ErrorDetails> handleHavaAlaniNotFoundException(HavaAlaniNotFoundException ex, WebRequest request) {
	    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	  }
	  @ExceptionHandler(KullaniciNotFoundException.class)
	  public final ResponseEntity<ErrorDetails> handleKullaniciNotFoundException(KullaniciNotFoundException ex, WebRequest request) {
	    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	  }
	  
	  @ExceptionHandler(MusteriNotFoundException.class)
	  public final ResponseEntity<ErrorDetails> handleMusteriFoundException(MusteriNotFoundException ex, WebRequest request) {
	    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	  }
	  @ExceptionHandler(TakvimNotFoundException.class)
	  public final ResponseEntity<ErrorDetails> handleTakvimFoundException(TakvimNotFoundException ex, WebRequest request) {
		  ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
			        request.getDescription(false));
		  return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

	  }
	  
	  
	  @ExceptionHandler(Exception.class)
	  public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
	    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	  

}
