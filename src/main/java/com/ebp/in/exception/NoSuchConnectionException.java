package com.ebp.in.exception;

public class NoSuchConnectionException extends Exception{
	private static final long serialVersionUID = 1L;
	public  NoSuchConnectionException(String str) {
		super(str);
	}
	public NoSuchConnectionException() {
		
	}
}
