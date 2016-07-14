package com.radhesh.studentportal.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.radhesh.studentportal.dao.CertificationDAO;
import com.radhesh.studentportal.model.Certification;

@Repository
public class CertificationDAOImpl extends AbstractBaseDAO<Serializable, Certification> implements CertificationDAO {

	private static Logger logger = Logger.getLogger(CertificationDAOImpl.class);

	public Certification findById(String name) {
		logger.info("Params - name: " + name);
		return get(name);
	}

	public void save(Certification Certification) {
		logger.info("Params - Certification: " + Certification);
		persist(Certification);
	}

	public void delete(Certification Certification) {
		logger.info("Params - Certification: " + Certification);
		super.delete(Certification);
	}

	@SuppressWarnings("unchecked")
	public List<Certification> findAll() {
		Criteria criteria = createCriteria();
		return (List<Certification>) criteria.list();
	}

	public Certification findByEmpId(Integer empId) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("empId", empId));
		return (Certification) criteria.uniqueResult();
	}

}