package com.cg.customer.exceptions;

public class InvalidCustomerNameException extends RuntimeException{
	
	public InvalidCustomerNameException() {		
	}
	
	public InvalidCustomerNameException(String str) {
		super(str);
	}
	
	

}
