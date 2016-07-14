package com.radhesh.studentportal.exception;

public class NonNullableFieldException extends Exception {

	public NonNullableFieldException() {
		super();
	}

	public NonNullableFieldException(String message) {
		super(message);
	}

	public NonNullableFieldException(Throwable cause) {
		super(cause);
	}

	public NonNullableFieldException(String message, Throwable cause) {
		super(message, cause);
	}
}
