package com.radhesh.studentportal.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.radhesh.studentportal.dao.HobbyDAO;
import com.radhesh.studentportal.model.Hobby;

@Repository
public class HobbyDAOImpl extends AbstractBaseDAO<Serializable, Hobby> implements HobbyDAO {

	private static Logger logger = Logger.getLogger(HobbyDAOImpl.class);

	public Hobby findById(String name) {
		logger.info("Params - name: " + name);
		return get(name);
	}

	public void save(Hobby Hobby) {
		logger.info("Params - Hobby: " + Hobby);
		persist(Hobby);
	}

	public void delete(Hobby Hobby) {
		logger.info("Params - Hobby: " + Hobby);
		super.delete(Hobby);
	}

	@SuppressWarnings("unchecked")
	public List<Hobby> findAll() {
		Criteria criteria = createCriteria();
		return (List<Hobby>) criteria.list();
	}

	public Hobby findByEmpId(Integer empId) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("empId", empId));
		return (Hobby) criteria.uniqueResult();
	}

}