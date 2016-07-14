package com.radhesh.studentportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.radhesh.studentportal.dao.HobbyDAO;
import com.radhesh.studentportal.model.Hobby;
import com.radhesh.studentportal.service.HobbyService;

@Service
@Transactional
public class HobbyServiceImpl implements HobbyService {

	@Autowired
	private HobbyDAO hobbyDAO;

	public Hobby findById(String name) {
		return hobbyDAO.findById(name);
	}

	public void save(Hobby hobby) {
		hobbyDAO.save(hobby);
	}

	public void update(Hobby hobby) {
		Hobby entity = hobbyDAO.findById(hobby.getName());
		if (entity != null) {
			// entity.setFirstName(hobby.getFirstName());
			// entity.setLastName(hobby.getLastName());
			// entity.setEnrollDate(hobby.getEnrollDate());
			// entity.setFee(hobby.getFee());
			// entity.setCourse(hobby.getCourse());
		}
	}

	public void delete(Hobby hobby) {
		hobbyDAO.delete(hobby);
	}

	public List<Hobby> findAll() {
		return hobbyDAO.findAll();
	}

	public Hobby findByEmpId(Integer empId) {
		return hobbyDAO.findByEmpId(empId);
	}
}
