package com.radhesh.studentportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.radhesh.studentportal.dao.AddressDAO;
import com.radhesh.studentportal.model.Address;
import com.radhesh.studentportal.refdata.AddressType;
import com.radhesh.studentportal.service.AddressService;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDAO addressDAO;

	public Address findById(AddressType addressType) {
		return addressDAO.findById(addressType);
	}

	public void save(Address address) {
		addressDAO.save(address);
	}

	public void update(Address address) {
		Address entity = addressDAO.findById(address.getAddressType());
		if (entity != null) {
			// entity.setFirstName(address.getFirstName());
			// entity.setLastName(address.getLastName());
			// entity.setEnrollDate(address.getEnrollDate());
			// entity.setFee(address.getFee());
			// entity.setCourse(address.getCourse());
		}
	}

	public void delete(Address address) {
		addressDAO.delete(address);
	}

	public List<Address> findAll() {
		return addressDAO.findAll();
	}

	public Address findByEmpId(Integer empId) {
		return addressDAO.findByEmpId(empId);
	}
}
