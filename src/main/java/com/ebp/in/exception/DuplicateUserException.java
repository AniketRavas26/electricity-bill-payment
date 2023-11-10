package com.ebp.in.exception;

public class DuplicateUserException extends Exception{
	private static final long serialVersionUID = 1L;
	public DuplicateUserException(String str) {
		super(str);
	}
	public DuplicateUserException() {
		
	}

}
