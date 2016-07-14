package com.radhesh.studentportal.util;

import java.util.Comparator;

import com.radhesh.studentportal.model.Student;

public class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student student1, Student student2) {
		return student1.getFirstName().compareToIgnoreCase(student2.getFirstName());
	}
}

