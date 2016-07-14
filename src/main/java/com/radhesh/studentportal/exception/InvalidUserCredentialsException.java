package com.radhesh.studentportal.exception;

public class InvalidUserCredentialsException extends Exception {

	public InvalidUserCredentialsException() {
		super();
	}

	public InvalidUserCredentialsException(String message) {
		super(message);
	}

	public InvalidUserCredentialsException(Throwable cause) {
		super(cause);
	}

	public InvalidUserCredentialsException(String message, Throwable cause) {
		super(message, cause);
	}
}
