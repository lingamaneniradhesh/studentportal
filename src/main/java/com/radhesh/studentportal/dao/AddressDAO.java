package com.radhesh.studentportal.dao;

import java.util.List;

import com.radhesh.studentportal.model.Address;
import com.radhesh.studentportal.refdata.AddressType;

public interface AddressDAO {

	Address findById(AddressType addressType);

	void save(Address address);

	void delete(Address address);

	List<Address> findAll();

	Address findByEmpId(Integer empId);
}
