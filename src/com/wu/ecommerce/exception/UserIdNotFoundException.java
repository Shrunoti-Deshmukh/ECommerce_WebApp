package com.wu.ecommerce.exception;

public class UserIdNotFoundException extends Exception {

	public UserIdNotFoundException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

}
