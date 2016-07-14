package com.radhesh.studentportal.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.radhesh.studentportal.dao.AcademicsDAO;
import com.radhesh.studentportal.model.Course;
import com.radhesh.studentportal.model.Student;
@Repository
public class AcademicsDAOImpl extends AbstractBaseDAO<Integer, Student> implements AcademicsDAO{

	@SuppressWarnings("unchecked")
	public List<Course> findAll() {
		Criteria criteria = createCriteria();
		return (List<Course>) criteria.list();
	}


}
