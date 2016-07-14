package com.radhesh.studentportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.radhesh.studentportal.dao.PhoneDAO;
import com.radhesh.studentportal.model.Phone;
import com.radhesh.studentportal.service.PhoneService;

@Service
@Transactional
public class PhoneServiceImpl implements PhoneService {

	@Autowired
	private PhoneDAO phoneDAO;

	public Phone findById(String mobileNumber) {
		return phoneDAO.findById(mobileNumber);
	}

	public void save(Phone phone) {
		phoneDAO.save(phone);
	}

	public void update(Phone phone) {
		Phone entity = phoneDAO.findById(phone.getMobileNumber());
		if (entity != null) {
			// entity.setFirstName(phone.getFirstName());
			// entity.setLastName(phone.getLastName());
			// entity.setEnrollDate(phone.getEnrollDate());
			// entity.setFee(phone.getFee());
			// entity.setCourse(phone.getCourse());
		}
	}

	public void delete(Phone phone) {
		phoneDAO.delete(phone);
	}

	public List<Phone> findAll() {
		return phoneDAO.findAll();
	}

	public Phone findByEmpId(Integer empId) {
		return phoneDAO.findByEmpId(empId);
	}
}
