package com.radhesh.studentportal.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.radhesh.studentportal.model.Contact;
import com.radhesh.studentportal.service.ContactService;
import com.radhesh.studentportal.util.ViewNameConstants;

@Controller
@RequestMapping("/contact")
public class ContactController implements ViewNameConstants {

	private static Logger logger = Logger.getLogger(ContactController.class);

	@Autowired
	private ContactService contactService;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = { "/about" }, method = RequestMethod.GET)
	public String about(ModelMap model) {
		Contact contact = new Contact();
		model.addAttribute("contact", contact);
		return CREATE_CONTACT_JSP;
	}

	@RequestMapping(value = { "/contact" }, method = RequestMethod.GET)
	public String contact(ModelMap model) {
		Contact contact = new Contact();
		model.addAttribute("contact", contact);
		return CREATE_CONTACT_JSP;
	}

	@RequestMapping(value = { "/contact" }, method = RequestMethod.POST)
	public String save(@Valid final Contact contact, final BindingResult result, final ModelMap model) {

		if (result.hasErrors()) {
			return CREATE_CONTACT_JSP;
		}
		contactService.save(contact);
		return CONTACT_REDIRECT_LIST;
	}

	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String list(ModelMap model) {
		List<Contact> contacts = contactService.findAll();
		model.addAttribute("contacts", contacts);
		if (logger.isDebugEnabled()) {
			logger.debug("contacts: " + contacts);
		}
		return CONTACTS_JSP;
	}
}
