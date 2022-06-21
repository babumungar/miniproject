package com.stg.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String message;
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public ResourceNotFoundException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

	
}
