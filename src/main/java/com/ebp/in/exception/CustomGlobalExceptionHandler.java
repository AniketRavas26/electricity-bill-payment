package com.ebp.in.exception;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    	List<String> errors  = ex.getBindingResult().getAllErrors()
    			.stream()
    			.map(x -> x.getDefaultMessage())
    			.collect(Collectors.toList());
		return new ResponseEntity<Object>(errors, status);
	}
	@ExceptionHandler(NoSuchCustomerException.class)
	public ResponseEntity<String> handleCustomerNotFoundException(NoSuchCustomerException cnfe){
		return new ResponseEntity<String>(cnfe.getLocalizedMessage(), HttpStatus.NOT_FOUND);
	}
 

	@ExceptionHandler(NoSuchConnectionException.class)
	public ResponseEntity<String> handleOrderNotFoundException(NoSuchConnectionException onfe) {
		return new ResponseEntity<String>(onfe.getLocalizedMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvalidReadingException.class)
	public ResponseEntity<String> handleInvalidDataException(InvalidReadingException ide){
		return new ResponseEntity<String>(ide.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NoSuchUserException.class)
	public ResponseEntity<String> handleUserNotFoundException(NoSuchUserException unfe){
		return new ResponseEntity<String>(unfe.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(DuplicateCustomerException.class)
	public ResponseEntity<String> handleUserNotFoundException(DuplicateCustomerException unfe){
		return new ResponseEntity<String>(unfe.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(DuplicateUserException.class)
	public ResponseEntity<String> handleUserNotFoundException(DuplicateUserException unfe){
		return new ResponseEntity<String>(unfe.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(InvalidLoginCredentialException.class)
	public ResponseEntity<String> handleUserNotFoundException(InvalidLoginCredentialException unfe){
		return new ResponseEntity<String>(unfe.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
	}
}
