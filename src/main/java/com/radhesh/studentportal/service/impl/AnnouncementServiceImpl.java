package com.radhesh.studentportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.radhesh.studentportal.dao.AnnouncementDAO;
import com.radhesh.studentportal.model.Announcement;
import com.radhesh.studentportal.service.AnnouncementService;

@Service
@Transactional
public class AnnouncementServiceImpl implements AnnouncementService {

	@Autowired
	private AnnouncementDAO announcementDAO;

	public Announcement findById(Integer id) {
		return announcementDAO.findById(id);
	}

	public List<Announcement> findByStartsWithOr(Announcement announcement) {
		return announcementDAO.findByStartsWithOr(announcement);
	}

	public void save(Announcement announcement) {
		announcementDAO.save(announcement);
	}

	public void update(Announcement announcement) {
		Announcement entity = announcementDAO.findById(announcement.getId());
		if (entity != null) {
			entity.setTitle(announcement.getTitle());
			entity.setDescription(announcement.getDescription());
			entity.setFromDate(announcement.getFromDate());
			entity.setToDate(announcement.getToDate());
		}
	}

	public void delete(Announcement announcement) {
		announcementDAO.delete(announcement);
	}

	public List<Announcement> findAll() {
		return announcementDAO.findAll();
	}

	public Announcement findByEmpId(Integer empId) {
		return announcementDAO.findByEmpId(empId);
	}
}
