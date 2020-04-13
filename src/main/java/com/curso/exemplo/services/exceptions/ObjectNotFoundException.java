package com.curso.exemplo.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6684233575219074438L;

	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjectNotFoundException(String message) {
		super(message);
	}
	
	

}
