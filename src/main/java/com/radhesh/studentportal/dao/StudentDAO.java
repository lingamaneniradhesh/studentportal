package com.radhesh.studentportal.dao;

import java.util.List;

import com.radhesh.studentportal.model.Student;

public interface StudentDAO {

	Student findById(Integer id);

	void save(Student student);

	void delete(Student student);

	void deleteByLastName(String lastName);

	List<Student> findAllStudents();

	Student findByLastName(String lastName);

	List<Student> findByStartsWithAnd(String firstName, String lastName);

	List<Student> findByStartsWithOr(Student student);
}
