package com.radhesh.studentportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.radhesh.studentportal.dao.ContactDAO;
import com.radhesh.studentportal.model.Contact;
import com.radhesh.studentportal.service.ContactService;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDAO contactDAO;

	public Contact findById(Integer id) {
		return contactDAO.findById(id);
	}

	public List<Contact> findByStartsWithOr(Contact contact) {
		return contactDAO.findByStartsWithOr(contact);
	}

	public void save(Contact contact) {
		contactDAO.save(contact);
	}

	public void update(Contact contact) {
		Contact entity = contactDAO.findById(contact.getId());
		if (entity != null) {
			entity.setFirstName(contact.getFirstName());
			entity.setLastName(contact.getLastName());
			entity.setEmail(contact.getEmail());
			entity.setPhoneNumber(contact.getPhoneNumber());
			entity.setDescription(contact.getDescription());
			entity.setContactDateTime(contact.getContactDateTime());
			entity.setResolutionStatus(contact.getResolutionStatus());
			entity.setResolution(contact.getResolution());
		}
	}

	public void delete(Contact contact) {
		contactDAO.delete(contact);
	}

	public List<Contact> findAll() {
		return contactDAO.findAll();
	}
}
