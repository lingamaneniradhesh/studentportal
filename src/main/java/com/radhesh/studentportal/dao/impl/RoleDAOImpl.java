package com.radhesh.studentportal.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.radhesh.studentportal.dao.RoleDAO;
import com.radhesh.studentportal.model.Role;

@Repository
public class RoleDAOImpl extends AbstractBaseDAO<Integer, Role> implements RoleDAO {

	private static Logger logger = Logger.getLogger(RoleDAOImpl.class);

	public Role findById(Integer id) {
		logger.info("Params - roleName: " + id);
		return get(id);
	}

	public void save(Role Role) {
		logger.info("Params - Role: " + Role);
		persist(Role);
	}

	public void delete(Role Role) {
		logger.info("Params - Role: " + Role);
		super.delete(Role);
	}

	@SuppressWarnings("unchecked")
	public List<Role> findAll() {
		Criteria criteria = createCriteria();
		return (List<Role>) criteria.list();
	}

	public Role findByEmpId(Integer empId) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("empId", empId));
		return (Role) criteria.uniqueResult();
	}

}