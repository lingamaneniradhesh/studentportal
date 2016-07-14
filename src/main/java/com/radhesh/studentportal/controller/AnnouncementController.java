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

import com.radhesh.studentportal.model.Announcement;
import com.radhesh.studentportal.service.AnnouncementService;
import com.radhesh.studentportal.util.ViewNameConstants;

@Controller
@RequestMapping("/announcement")
public class AnnouncementController implements ViewNameConstants {

	private static Logger logger = Logger.getLogger(ContactController.class);

	@Autowired
	private AnnouncementService announcementService;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = { "/create" }, method = RequestMethod.GET)
	public String create(ModelMap model) {
		Announcement announcement = new Announcement();
		model.addAttribute("announcement", announcement);
		return CREATE_ANNOUNCEMENT_JSP;
	}

	@RequestMapping(value = { "/create" }, method = RequestMethod.POST)
	public String save(@Valid final Announcement announcement, final BindingResult result, final ModelMap model) {

		if (result.hasErrors()) {
			return CREATE_ANNOUNCEMENT_JSP;
		}
		announcementService.save(announcement);
		return ANNOUNCEMENT_REDIRECT_LIST;
	}

	@RequestMapping(value = { "/edit-{id}-announcement" }, method = RequestMethod.GET)
	public String show(@PathVariable String id, ModelMap model) {
		logger.info("annoucementId: " + id);
		Announcement announcement = announcementService.findById(new Integer(id));
		model.addAttribute("announcement", announcement);
		model.addAttribute("edit", true);
		return UPDATE_ANNOUNCEMENT_JSP;
	}

	@RequestMapping(value = { "/edit-{id}-announcement" }, method = RequestMethod.POST)
	public String update(@Valid Announcement announcement, BindingResult result, ModelMap model,
			@PathVariable String id) {

		if (result.hasErrors()) {
			return UPDATE_ANNOUNCEMENT_JSP;
		}
		announcementService.update(announcement);
		return ANNOUNCEMENT_REDIRECT_LIST;
	}

	@RequestMapping(value = { "/update" }, method = RequestMethod.GET)
	public String search(ModelMap model) {
		model.addAttribute("announcement", new Announcement());
		return SEARCH_AND_UPDATE_ANNOUNCEMENT_JSP;
	}

	@RequestMapping(value = { "/update" }, method = RequestMethod.POST)
	public String search(final Announcement announcement, final BindingResult result, final ModelMap model) {
		List<Announcement> announcements = announcementService.findByStartsWithOr(announcement);
		model.addAttribute("announcement", announcement);
		model.addAttribute("announcements", announcements);	
		return SEARCH_AND_UPDATE_ANNOUNCEMENT_JSP;
	}

	@RequestMapping(value = { "/delete-{id}-announcement" }, method = RequestMethod.GET)
	public String delete(@PathVariable String id) {
		Announcement announcement = announcementService.findById(new Integer(id));
		announcementService.delete(announcement);
		return ANNOUNCEMENT_REDIRECT_LIST;
	}

	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String list(ModelMap model) {
		List<Announcement> announcements = announcementService.findAll();
		model.addAttribute("announcements", announcements);
		if (logger.isDebugEnabled()) {
			logger.debug("announcements: " + announcements);
		}
		return ANNOUNCEMENTS_JSP;
	}
}
