package com.radhesh.studentportal.dao;

import java.util.List;

import com.radhesh.studentportal.model.Greeting;

public interface GreetingDAO {

	Greeting findById(String message);

	void save(Greeting greeting);

	void delete(Greeting greeting);

	List<Greeting> findAll();

	Greeting findByEmpId(Integer empId);
}
