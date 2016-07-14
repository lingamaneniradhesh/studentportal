package com.radhesh.studentportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.radhesh.studentportal.dao.GreetingDAO;
import com.radhesh.studentportal.model.Greeting;
import com.radhesh.studentportal.service.GreetingService;

@Service
@Transactional
public class GreetingServiceImpl implements GreetingService {

	@Autowired
	private GreetingDAO greetingDAO;

	public Greeting findById(String message) {
		return greetingDAO.findById(message);
	}

	public void save(Greeting greeting) {
		greetingDAO.save(greeting);
	}

	public void update(Greeting greeting) {
		Greeting entity = greetingDAO.findById(greeting.getMessage());
		if (entity != null) {
			// entity.setFirstName(greeting.getFirstName());
			// entity.setLastName(greeting.getLastName());
			// entity.setEnrollDate(greeting.getEnrollDate());
			// entity.setFee(greeting.getFee());
			// entity.setCourse(greeting.getCourse());
		}
	}

	public void delete(Greeting greeting) {
		greetingDAO.delete(greeting);
	}

	public List<Greeting> findAll() {
		return greetingDAO.findAll();
	}

	public Greeting findByEmpId(Integer empId) {
		return greetingDAO.findByEmpId(empId);
	}
}
