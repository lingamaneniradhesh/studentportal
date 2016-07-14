package com.radhesh.studentportal.service;

import java.util.List;

import com.radhesh.studentportal.exception.InvalidUserCredentialsException;
import com.radhesh.studentportal.exception.NonNullableFieldException;
import com.radhesh.studentportal.model.User;

public interface UserService {

	User findById(Integer id);

	void save(User user);

	void update(User user);

	void delete(User user);

	List<User> findAll();

	User findByEmpId(Integer empId);

	User signIn(String userName, String password) throws NonNullableFieldException, InvalidUserCredentialsException;
}
