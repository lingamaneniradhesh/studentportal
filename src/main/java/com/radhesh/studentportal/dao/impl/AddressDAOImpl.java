package com.radhesh.studentportal.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.radhesh.studentportal.dao.AddressDAO;
import com.radhesh.studentportal.model.Address;
import com.radhesh.studentportal.refdata.AddressType;

@Repository
public class AddressDAOImpl extends AbstractBaseDAO<AddressType, Address> implements AddressDAO {

	private static Logger logger = Logger.getLogger(AddressDAOImpl.class);

	public Address findById(AddressType addressType) {
		logger.info("Params - addressType: " + addressType);
		return get(addressType);
	}

	public void save(Address Address) {
		logger.info("Params - Address: " + Address);
		persist(Address);
	}

	public void delete(Address address) {
		logger.info("Params - Address: " + address);
		super.delete(address);
	}

	@SuppressWarnings("unchecked")
	public List<Address> findAll() {
		Criteria criteria = createCriteria();
		return (List<Address>) criteria.list();
	}

	public Address findByEmpId(Integer empId) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("empId", empId));
		return (Address) criteria.uniqueResult();
	}

}