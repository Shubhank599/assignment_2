package com.cg.customer.exceptions;

public class InvalidArgumentException extends RuntimeException {

	public InvalidArgumentException() {

	}

	public InvalidArgumentException(String str) {
		super(str);
	}
}
