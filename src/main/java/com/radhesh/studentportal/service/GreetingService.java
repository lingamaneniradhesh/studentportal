package com.radhesh.studentportal.service;

import java.util.List;

import com.radhesh.studentportal.model.Greeting;

public interface GreetingService {

	Greeting findById(String message);

	void save(Greeting greeting);

	void update(Greeting greeting);

	void delete(Greeting greeting);

	List<Greeting> findAll();

	Greeting findByEmpId(Integer empId);
}
