package com.radhesh.studentportal.dao;

import java.util.List;

import com.radhesh.studentportal.model.Certification;

public interface CertificationDAO {

	Certification findById(String name);

	void save(Certification certification);

	void delete(Certification certification);

	List<Certification> findAll();

	Certification findByEmpId(Integer empId);
}
