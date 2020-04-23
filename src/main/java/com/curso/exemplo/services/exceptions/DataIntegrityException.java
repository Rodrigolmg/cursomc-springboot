package com.curso.exemplo.services.exceptions;

public class DataIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 6684233575219074438L;

	public DataIntegrityException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataIntegrityException(String message) {
		super(message);
	}
	
	

}
