package com.radhesh.studentportal.service;

import java.util.List;

import com.radhesh.studentportal.model.Hobby;

public interface HobbyService {

	Hobby findById(String name);

	void save(Hobby hobby);

	void update(Hobby hobby);

	void delete(Hobby hobby);

	List<Hobby> findAll();

	Hobby findByEmpId(Integer empId);
}
