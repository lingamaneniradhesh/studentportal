package com.radhesh.studentportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.radhesh.studentportal.dao.CertificationDAO;
import com.radhesh.studentportal.model.Certification;
import com.radhesh.studentportal.service.CertificationService;

@Service
@Transactional
public class CertificationServiceImpl implements CertificationService {

	@Autowired
	private CertificationDAO certificationDAO;

	public Certification findById(String name) {
		return certificationDAO.findById(name);
	}

	public void save(Certification certification) {
		certificationDAO.save(certification);
	}

	public void update(Certification certification) {
		Certification entity = certificationDAO.findById(certification.getCertificationName());
		if (entity != null) {
			// entity.setFirstName(certification.getFirstName());
			// entity.setLastName(certification.getLastName());
			// entity.setEnrollDate(certification.getEnrollDate());
			// entity.setFee(certification.getFee());
			// entity.setCourse(certification.getCourse());
		}
	}

	public void delete(Certification certification) {
		certificationDAO.delete(certification);
	}

	public List<Certification> findAll() {
		return certificationDAO.findAll();
	}

	public Certification findByEmpId(Integer empId) {
		return certificationDAO.findByEmpId(empId);
	}
}
