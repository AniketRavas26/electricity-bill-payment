package com.ebp.in.exception;


public class DuplicateCustomerException extends Exception{
	private static final long serialVersionUID = 1L;
	public DuplicateCustomerException(String str) {
		super(str);
	}
	public DuplicateCustomerException() {
		
	}
}
