package com.radhesh.studentportal.service.impl;

import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.radhesh.studentportal.dao.TimeInOutDAO;
import com.radhesh.studentportal.model.TimeInOut;
import com.radhesh.studentportal.service.TimeInOutService;

@Service
@Transactional
public class TimeInOutServiceImpl implements TimeInOutService {

	@Autowired
	private TimeInOutDAO timeInOutDAO;

	public TimeInOut findById(LocalDate ioDate) {
		return timeInOutDAO.findById(ioDate);
	}

	public void save(TimeInOut timeInOut) {
		timeInOutDAO.save(timeInOut);
	}

	public void update(TimeInOut timeInOut) {
		TimeInOut entity = timeInOutDAO.findById(timeInOut.getIoDate());
		if (entity != null) {
			 entity.setInTime(timeInOut.getInTime());
			 entity.setIoDate(timeInOut.getIoDate());
			 entity.setOutTime(timeInOut.getOutTime());
			 entity.setStudent(timeInOut.getStudent());
		}
	}

	public void delete(TimeInOut timeInOut) {
		timeInOutDAO.delete(timeInOut);
	}

	public List<TimeInOut> findAll() {
		return timeInOutDAO.findAll();
	}

	public TimeInOut findByEmpId(Integer empId) {
		return timeInOutDAO.findByEmpId(empId);
	}
}
