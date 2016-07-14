package com.radhesh.studentportal.service;

import java.util.List;

import com.radhesh.studentportal.model.Address;
import com.radhesh.studentportal.model.Course;
import com.radhesh.studentportal.refdata.CourseType;

public interface AcademicsService {
	

	Address findById(CourseType CourseType);

	void save(Course course);

	void update(Course course);

	void delete(Course course);
	
	List<Course> findAll();
	
	Course findByEmpId(Integer empId);
}
