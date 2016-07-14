package com.radhesh.studentportal.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.radhesh.studentportal.dao.RoleDAO;
import com.radhesh.studentportal.model.Role;
import com.radhesh.studentportal.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	private static Logger logger = Logger.getLogger(RoleServiceImpl.class);

	@Autowired
	private RoleDAO roleDAO;

	public Role findById(Integer id) {
		return roleDAO.findById(id);
	}

	public void save(Role role) {
		roleDAO.save(role);
	}

	public void update(Role role) {
		Role entity = roleDAO.findById(role.getId());
		if (entity != null) {
			entity.setRoleName(role.getRoleName());
			entity.setUsers(role.getUsers());
		}
	}

	public void delete(Role role) {
		roleDAO.delete(role);
	}

	public List<Role> findAll() {
		return roleDAO.findAll();
	}

	public Role findByEmpId(Integer empId) {
		return roleDAO.findByEmpId(empId);
	}
}
