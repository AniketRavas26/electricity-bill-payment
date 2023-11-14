package com.ebp.in.exception;

public class NoSuchCustomerException extends Exception {
	private static final long serialVersionUID = 1L;
	String str="No Customer Exist!";
	public NoSuchCustomerException(String str) {
		
		super(str);
	}

	public NoSuchCustomerException() {
		
	}

}
