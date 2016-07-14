package com.radhesh.studentportal.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.radhesh.studentportal.dao.UserDAO;
import com.radhesh.studentportal.exception.InvalidUserCredentialsException;
import com.radhesh.studentportal.exception.NonNullableFieldException;
import com.radhesh.studentportal.model.User;
import com.radhesh.studentportal.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private static Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDAO userDAO;

	public User findById(Integer id) {
		return userDAO.findById(id);
	}

	public void save(User user) {
		userDAO.save(user);
	}

	public void update(User user) {
		User entity = userDAO.findById(user.getId());
		if (entity != null) {
			entity.setUserName(user.getUserName());
			entity.setPassword(user.getPassword());
			entity.setIsEnabled(user.getIsEnabled());
			entity.setStudent(user.getStudent());
			entity.setRole(user.getRole());
		}
	}

	public void delete(User user) {
		userDAO.delete(user);
	}

	public List<User> findAll() {
		return userDAO.findAll();
	}

	public User findByEmpId(Integer empId) {
		return userDAO.findByEmpId(empId);
	}

	public User signIn(String userName, String password) throws NonNullableFieldException, InvalidUserCredentialsException {
		logger.info("Params - userName: " + userName + " password: MASKED");
		User signedInUser = userDAO.findByUserName(userName);
		boolean isMatched = new BCryptPasswordEncoder().matches(password, signedInUser.getPassword());
		if (!isMatched) {
			throw new InvalidUserCredentialsException("Invalid userName or password");
		}
		logger.info("Return - signedInUser: " + signedInUser);
		return signedInUser;
	}
}
