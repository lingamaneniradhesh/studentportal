package com.radhesh.studentportal.service;

import java.util.List;

import com.radhesh.studentportal.model.Student;

public interface StudentService {

	Student findById(Integer id);

	void save(Student student);

	void update(Student student);

	void delete(Student student);

	void deleteByLastName(String lastName);

	List<Student> findAll();

	Student findByLastName(String lastName);

	List<Student> findByStartsWithAnd(String firstName, String lastName);
	
	List<Student> findByStartsWithOr(Student student);
}
