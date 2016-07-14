package com.radhesh.studentportal.dao;

import java.util.List;

import com.radhesh.studentportal.model.Role;

public interface RoleDAO {

	Role findById(Integer id);

	void save(Role role);

	void delete(Role role);

	List<Role> findAll();

	Role findByEmpId(Integer empId);

}
