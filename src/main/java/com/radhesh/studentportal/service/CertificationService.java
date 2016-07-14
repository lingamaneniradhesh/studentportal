package com.radhesh.studentportal.service;

import java.util.List;

import com.radhesh.studentportal.model.Certification;

public interface CertificationService {

	Certification findById(String name);

	void save(Certification certification);

	void update(Certification certification);

	void delete(Certification certification);

	List<Certification> findAll();

	Certification findByEmpId(Integer empId);
}
