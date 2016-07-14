package com.radhesh.studentportal.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.radhesh.studentportal.model.Role;
import com.radhesh.studentportal.service.RoleService;
import com.radhesh.studentportal.util.ViewNameConstants;

@Controller
@RequestMapping("/role")
public class RoleController implements ViewNameConstants {

	private static Logger logger = Logger.getLogger(RoleController.class);

	@Autowired
	private RoleService roleService;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = { "/create" }, method = RequestMethod.GET)
	public String create(ModelMap model) {
		Role role = new Role();
		model.addAttribute("role", role);
		return CREATE_ROLE_JSP;
	}

	@RequestMapping(value = { "/create" }, method = RequestMethod.POST)
	public String save(@Valid final Role role, final BindingResult result, final ModelMap model) {

		if (result.hasErrors()) {
			return CREATE_ROLE_JSP;
		}
		roleService.save(role);
		return ROLE_REDIRECT_LIST;
	}

	@RequestMapping(value = { "/edit-{id}-role" }, method = RequestMethod.GET)
	public String show(@PathVariable String id, ModelMap model) {
		Role role = roleService.findById(new Integer(id));
		model.addAttribute("role", role);
		model.addAttribute("edit", true);
		return UPDATE_ROLE_JSP;
	}

	@RequestMapping(value = { "/edit-{id}-role" }, method = RequestMethod.POST)
	public String update(@Valid Role role, BindingResult result, ModelMap model, @PathVariable String id) {

		if (result.hasErrors()) {
			return UPDATE_ROLE_JSP;
		}
		roleService.update(role);
		return ROLE_REDIRECT_LIST;
	}

	@RequestMapping(value = { "/update" }, method = RequestMethod.GET)
	public String search(ModelMap model) {
		return list(model);
	}

	@RequestMapping(value = { "/delete-{id}-role" }, method = RequestMethod.GET)
	public String delete(@PathVariable String id) {
		Role role = roleService.findById(new Integer(id));
		roleService.delete(role);
		return ROLE_REDIRECT_LIST;
	}

	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String list(ModelMap model) {
		List<Role> roles = roleService.findAll();
		model.addAttribute("roles", roles);
		if (logger.isDebugEnabled()) {
			logger.debug("roles: " + roles);
		}
		return ROLES_JSP;
	}
}
