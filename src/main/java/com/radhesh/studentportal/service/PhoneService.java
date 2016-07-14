package com.radhesh.studentportal.service;

import java.util.List;

import com.radhesh.studentportal.model.Phone;

public interface PhoneService {

	Phone findById(String mobileNumber);

	void save(Phone phone);

	void update(Phone phone);

	void delete(Phone phone);

	List<Phone> findAll();

	Phone findByEmpId(Integer empId);
}
