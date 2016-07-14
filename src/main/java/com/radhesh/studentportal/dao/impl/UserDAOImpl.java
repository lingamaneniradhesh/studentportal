package com.radhesh.studentportal.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.radhesh.studentportal.dao.UserDAO;
import com.radhesh.studentportal.model.User;

@Repository
public class UserDAOImpl extends AbstractBaseDAO<Integer, User> implements UserDAO {

	private static Logger logger = Logger.getLogger(UserDAOImpl.class);

	public User findById(Integer id) {
		logger.info("Params - userName: " + id);
		return get(id);
	}

	public void save(User User) {
		logger.info("Params - User: " + User);
		persist(User);
	}

	public void delete(User User) {
		logger.info("Params - User: " + User);
		super.delete(User);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		Criteria criteria = createCriteria();
		return (List<User>) criteria.list();
	}

	public User findByEmpId(Integer empId) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("empId", empId));
		return (User) criteria.uniqueResult();
	}

	public User findByUserNameAndPassword(String userName, String password) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("userName", userName));
		criteria.add(Restrictions.eq("password", password));
		return (User) criteria.uniqueResult();
	}

	public User findByUserName(String userName) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("userName", userName));
		return (User) criteria.uniqueResult();
	}
}