package com.ebp.in.exception;

public class InvalidLoginCredentialException extends Exception{
	private static final long serialVersionUID = 1L;
	public InvalidLoginCredentialException(String str) {
		super(str);
	}
	public InvalidLoginCredentialException() {
		
	}
}
