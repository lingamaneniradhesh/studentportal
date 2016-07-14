package com.radhesh.studentportal.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.radhesh.studentportal.dao.QualificationDAO;
import com.radhesh.studentportal.model.Qualification;

@Repository
public class QualificationDAOImpl extends AbstractBaseDAO<Serializable, Qualification> implements QualificationDAO {

	private static Logger logger = Logger.getLogger(QualificationDAOImpl.class);

	public Qualification findById(String name) {
		logger.info("Params - name: " + name);
		return get(name);
	}

	public void save(Qualification Qualification) {
		logger.info("Params - Qualification: " + Qualification);
		persist(Qualification);
	}

	public void delete(Qualification Qualification) {
		logger.info("Params - Qualification: " + Qualification);
		super.delete(Qualification);
	}

	@SuppressWarnings("unchecked")
	public List<Qualification> findAll() {
		Criteria criteria = createCriteria();
		return (List<Qualification>) criteria.list();
	}

	public Qualification findByEmpId(Integer empId) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("empId", empId));
		return (Qualification) criteria.uniqueResult();
	}

}