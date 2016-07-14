package com.radhesh.studentportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.radhesh.studentportal.dao.QualificationDAO;
import com.radhesh.studentportal.model.Qualification;
import com.radhesh.studentportal.service.QualificationService;

@Service
@Transactional
public class QualificationServiceImpl implements QualificationService {

	@Autowired
	private QualificationDAO qualificationDAO;

	public Qualification findById(String name) {
		return qualificationDAO.findById(name);
	}

	public void save(Qualification qualification) {
		qualificationDAO.save(qualification);
	}

	public void update(Qualification qualification) {
		Qualification entity = qualificationDAO.findById(qualification.getName());
		if (entity != null) {
			// entity.setFirstName(qualification.getFirstName());
			// entity.setLastName(qualification.getLastName());
			// entity.setEnrollDate(qualification.getEnrollDate());
			// entity.setFee(qualification.getFee());
			// entity.setCourse(qualification.getCourse());
		}
	}

	public void delete(Qualification qualification) {
		qualificationDAO.delete(qualification);
	}

	public List<Qualification> findAll() {
		return qualificationDAO.findAll();
	}

	public Qualification findByEmpId(Integer empId) {
		return qualificationDAO.findByEmpId(empId);
	}
}
