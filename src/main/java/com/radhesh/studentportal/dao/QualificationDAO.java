package com.radhesh.studentportal.dao;

import java.util.List;

import com.radhesh.studentportal.model.Qualification;

public interface QualificationDAO {

	Qualification findById(String name);

	void save(Qualification qualification);

	void delete(Qualification qualification);

	List<Qualification> findAll();

	Qualification findByEmpId(Integer empId);
}
