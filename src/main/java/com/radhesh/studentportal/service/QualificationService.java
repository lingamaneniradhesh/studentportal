package com.radhesh.studentportal.service;

import java.util.List;

import com.radhesh.studentportal.model.Qualification;

public interface QualificationService {

	Qualification findById(String name);

	void save(Qualification qualification);

	void update(Qualification qualification);

	void delete(Qualification qualification);

	List<Qualification> findAll();

	Qualification findByEmpId(Integer empId);
}
