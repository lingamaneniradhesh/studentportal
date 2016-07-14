package com.radhesh.studentportal.exception;

public class StudentNotFoundException extends Exception {

	public StudentNotFoundException() {
		super();
	}

	public StudentNotFoundException(String message) {
		super(message);
	}

	public StudentNotFoundException(Throwable cause) {
		super(cause);
	}

	public StudentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
