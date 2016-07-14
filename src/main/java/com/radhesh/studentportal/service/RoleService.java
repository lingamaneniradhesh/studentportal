package com.radhesh.studentportal.service;

import java.util.List;

import com.radhesh.studentportal.model.Role;

public interface RoleService {

	Role findById(Integer id);

	void save(Role role);

	void update(Role role);

	void delete(Role role);

	List<Role> findAll();

}
