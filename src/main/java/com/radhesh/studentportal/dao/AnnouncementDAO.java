package com.radhesh.studentportal.dao;

import java.util.List;

import com.radhesh.studentportal.model.Announcement;

public interface AnnouncementDAO {

	Announcement findById(Integer id);

	List<Announcement> findByStartsWithOr(Announcement announcement);

	void save(Announcement announcement);

	void delete(Announcement announcement);

	List<Announcement> findAll();

	Announcement findByEmpId(Integer empId);
}
