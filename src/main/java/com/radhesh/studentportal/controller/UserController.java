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

import com.radhesh.studentportal.model.User;
import com.radhesh.studentportal.service.UserService;
import com.radhesh.studentportal.util.ViewNameConstants;

@Controller
@RequestMapping("/user")
public class UserController implements ViewNameConstants {

	private static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = { "/create" }, method = RequestMethod.GET)
	public String create(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return CREATE_USER_JSP;
	}

	@RequestMapping(value = { "/create" }, method = RequestMethod.POST)
	public String save(@Valid final User user, final BindingResult result, final ModelMap model) {

		if (result.hasErrors()) {
			return CREATE_USER_JSP;
		}
		userService.save(user);
		return USER_REDIRECT_LIST;
	}

	@RequestMapping(value = { "/edit-{id}-user" }, method = RequestMethod.GET)
	public String show(@PathVariable String id, ModelMap model) {
		User user = userService.findById(new Integer(id));
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		return UPDATE_USER_JSP;
	}

	@RequestMapping(value = { "/edit-{id}-user" }, method = RequestMethod.POST)
	public String update(@Valid User user, BindingResult result, ModelMap model, @PathVariable String id) {

		if (result.hasErrors()) {
			return UPDATE_USER_JSP;
		}
		userService.update(user);
		return USER_REDIRECT_LIST;
	}

	@RequestMapping(value = { "/update" }, method = RequestMethod.GET)
	public String search(ModelMap model) {
		return SEARCH_AND_UPDATE_USER_JSP;
	}

	@RequestMapping(value = { "/delete-{id}-user" }, method = RequestMethod.GET)
	public String delete(@PathVariable String id) {
		User user = userService.findById(new Integer(id));
		userService.delete(user);
		return USER_REDIRECT_LIST;
	}

	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String list(ModelMap model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		if (logger.isDebugEnabled()) {
			logger.debug("users: " + users);
		}
		return USERS_JSP;
	}
}
