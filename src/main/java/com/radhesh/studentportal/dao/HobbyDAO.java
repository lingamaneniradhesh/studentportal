package com.radhesh.studentportal.dao;

import java.util.List;

import com.radhesh.studentportal.model.Hobby;

public interface HobbyDAO {

	Hobby findById(String name);

	void save(Hobby hobby);

	void delete(Hobby hobby);

	List<Hobby> findAll();

	Hobby findByEmpId(Integer empId);
}
