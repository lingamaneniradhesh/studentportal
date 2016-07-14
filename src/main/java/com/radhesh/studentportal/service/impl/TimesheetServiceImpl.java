package com.radhesh.studentportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.radhesh.studentportal.dao.TimesheetDAO;
import com.radhesh.studentportal.model.Timesheet;
import com.radhesh.studentportal.service.TimesheetService;

@Service
@Transactional
public class TimesheetServiceImpl implements TimesheetService {

	@Autowired
	private TimesheetDAO timesheetDAO;

	public Timesheet findById(Integer id) {
		return timesheetDAO.findById(id);
	}

	public void save(Timesheet timesheet) {
		timesheetDAO.save(timesheet);
	}

	public void update(Timesheet timesheet) {
		Timesheet entity = timesheetDAO.findById(timesheet.getStudent().getId());
		if (entity != null) {
			 entity.setHrs(timesheet.getHrs());
			 entity.setMins(timesheet.getMins());
			 entity.setStudent(timesheet.getStudent());
			 entity.setTask(timesheet.getTask());
			 entity.setTsDate(timesheet.getTsDate());
		}
	}

	public void delete(Timesheet timesheet) {
		timesheetDAO.delete(timesheet);
	}

	public List<Timesheet> findAll() {
		return timesheetDAO.findAll();
	}

	public Timesheet findByEmpId(Integer empId) {
		return timesheetDAO.findByEmpId(empId);
	}
}
