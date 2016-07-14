package com.radhesh.studentportal.dao;

import java.util.List;

import com.radhesh.studentportal.model.Course;

public interface AcademicsDAO {

	

	List<Course> findAll();
	
	
}
