package com.radhesh.studentportal.dao;

import java.util.List;

import com.radhesh.studentportal.model.User;

public interface UserDAO {

	User findById(Integer id);

	void save(User user);

	void delete(User user);

	List<User> findAll();

	User findByUserNameAndPassword(String userName, String password);

	User findByUserName(String userName);

	User findByEmpId(Integer empId);

}
