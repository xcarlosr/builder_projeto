package br.com.builder.exceptions;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3528073147186733226L;

	public ObjectNotFoundException(String message) {
		super(message);
	}

	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
