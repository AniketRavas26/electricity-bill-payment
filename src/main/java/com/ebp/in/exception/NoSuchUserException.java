package com.ebp.in.exception;

public class NoSuchUserException extends Exception {
	private static final long serialVersionUID = 1L;
	public NoSuchUserException(String str) {
		super(str);
	}
	public NoSuchUserException() {
		
	}
}
