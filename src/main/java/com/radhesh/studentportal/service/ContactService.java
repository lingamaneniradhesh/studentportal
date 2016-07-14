package com.radhesh.studentportal.service;

import java.util.List;

import com.radhesh.studentportal.model.Contact;

public interface ContactService {

	Contact findById(Integer id);

	List<Contact> findByStartsWithOr(Contact contact);

	void save(Contact contact);

	void update(Contact contact);

	void delete(Contact contact);

	List<Contact> findAll();
}
