package com.radhesh.studentportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.radhesh.studentportal.dao.AcademicsDAO;
import com.radhesh.studentportal.model.Address;
import com.radhesh.studentportal.model.Course;
import com.radhesh.studentportal.refdata.CourseType;
import com.radhesh.studentportal.service.AcademicsService;


@Service
@Transactional
public class AcademicsServiceImpl implements AcademicsService{
	
	@Autowired
	private AcademicsDAO academicsDAO;
	

	@Override
	public Address findById(CourseType CourseType) {
		return null;
	}

	@Override
	public void save(Course course) {
		
	}

	@Override
	public void update(Course course) {
		
	}

	@Override
	public void delete(Course course) {
		
	}

	@Override
	public List<Course> findAll() {
		return  academicsDAO.findAll();
	}

	@Override
	public Course findByEmpId(Integer empId) {	
		return null;
	}

}
