package com.radhesh.studentportal.dao;

import java.util.List;

import com.radhesh.studentportal.model.Phone;

public interface PhoneDAO {

	Phone findById(String mobileNumber);

	void save(Phone phone);

	void delete(Phone phone);

	List<Phone> findAll();

	Phone findByEmpId(Integer empId);
}
