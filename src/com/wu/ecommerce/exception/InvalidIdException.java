package com.wu.ecommerce.exception;

public class InvalidIdException extends Exception {
	public InvalidIdException(String msg)
	{
		super(msg);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
}
