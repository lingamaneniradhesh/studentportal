package com.radhesh.studentportal.model;

import java.io.Serializable;

public class Person implements Serializable {

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(getClass().getSimpleName());
		builder.append("[");
		builder.append("]");
		return builder.toString();
	}
}
