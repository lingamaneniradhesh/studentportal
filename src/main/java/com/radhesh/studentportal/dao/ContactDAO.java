package com.radhesh.studentportal.dao;

import java.util.List;

import com.radhesh.studentportal.model.Contact;

public interface ContactDAO {

	Contact findById(Integer id);

	List<Contact> findByStartsWithOr(Contact contact);

	void save(Contact contact);

	void delete(Contact contact);

	List<Contact> findAll();
}
