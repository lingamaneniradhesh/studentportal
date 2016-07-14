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

import com.radhesh.studentportal.model.Vacation;
import com.radhesh.studentportal.refdata.LeaveType;
import com.radhesh.studentportal.service.VacationService;
import com.radhesh.studentportal.util.ViewNameConstants;

@Controller
@RequestMapping("/vacation")
public class VacationController implements ViewNameConstants {

	private static Logger logger = Logger.getLogger(VacationController.class);

	@Autowired
	private VacationService vacationService;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = { "/create" }, method = RequestMethod.GET)
	public String create(ModelMap model) {
		Vacation vacation = new Vacation();
		model.addAttribute("vacation", vacation);
		return CREATE_USER_JSP;
	}

	@RequestMapping(value = { "/create" }, method = RequestMethod.POST)
	public String save(@Valid final Vacation vacation, final BindingResult result, final ModelMap model) {

		if (result.hasErrors()) {
			return CREATE_USER_JSP;
		}
		vacationService.save(vacation);
		return USER_REDIRECT_LIST;
	}

	@RequestMapping(value = { "/edit-{id}-vacation" }, method = RequestMethod.GET)
	public String show(@PathVariable LeaveType id, ModelMap model) {
		Vacation vacation = vacationService.findById(id);
		model.addAttribute("vacation", vacation);
		model.addAttribute("edit", true);
		return UPDATE_USER_JSP;
	}

	@RequestMapping(value = { "/edit-{id}-vacation" }, method = RequestMethod.POST)
	public String update(@Valid Vacation vacation, BindingResult result, ModelMap model, @PathVariable String id) {

		if (result.hasErrors()) {
			return UPDATE_USER_JSP;
		}
		vacationService.update(vacation);
		return USER_REDIRECT_LIST;
	}

	@RequestMapping(value = { "/update" }, method = RequestMethod.GET)
	public String search(ModelMap model) {
		return SEARCH_AND_UPDATE_VACATION_JSP;
	}

	@RequestMapping(value = { "/delete-{id}-vacation" }, method = RequestMethod.GET)
	public String delete(@PathVariable LeaveType id) {
		Vacation vacation = vacationService.findById(id);
		vacationService.delete(vacation);
		return USER_REDIRECT_LIST;
	}

	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String list(ModelMap model) {
		List<Vacation> vacations = vacationService.findAll();
		model.addAttribute("vacations", vacations);
		if (logger.isDebugEnabled()) {
			logger.debug("vacations: " + vacations);
		}
		return VACATIONS_JSP;
	}
}
