package com.ebp.in.exception;

public class NoSuchConnectionException extends Exception{
	String str="No Such Customer Exist";
	private static final long serialVersionUID = 1L;
	public  NoSuchConnectionException(String str) {
		super(str);
	}
	public NoSuchConnectionException() {
		
	}
}
