package com.radhesh.studentportal.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.radhesh.studentportal.dao.PhoneDAO;
import com.radhesh.studentportal.model.Phone;

@Repository
public class PhoneDAOImpl extends AbstractBaseDAO<Serializable, Phone> implements PhoneDAO {

	private static Logger logger = Logger.getLogger(PhoneDAOImpl.class);

	public Phone findById(String mobileNumber) {
		logger.info("Params - mobileNumber: " + mobileNumber);
		return get(mobileNumber);
	}

	public void save(Phone phone) {
		logger.info("Params - phone: " + phone);
		persist(phone);
	}

	public void delete(Phone phone) {
		logger.info("Params - phone: " + phone);
		super.delete(phone);
	}

	@SuppressWarnings("unchecked")
	public List<Phone> findAll() {
		Criteria criteria = createCriteria();
		return (List<Phone>) criteria.list();
	}

	public Phone findByEmpId(Integer empId) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("empId", empId));
		return (Phone) criteria.uniqueResult();
	}

}