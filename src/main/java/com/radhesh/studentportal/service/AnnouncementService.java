package com.radhesh.studentportal.service;

import java.util.List;

import com.radhesh.studentportal.model.Announcement;

public interface AnnouncementService {

	Announcement findById(Integer id);

	List<Announcement> findByStartsWithOr(Announcement announcement);

	void save(Announcement announcement);

	void update(Announcement announcement);

	void delete(Announcement announcement);

	List<Announcement> findAll();

	Announcement findByEmpId(Integer empId);
}
