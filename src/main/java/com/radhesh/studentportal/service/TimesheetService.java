package com.radhesh.studentportal.service;

import java.util.List;

import com.radhesh.studentportal.model.Timesheet;

public interface TimesheetService {

	Timesheet findById(Integer id);

	void save(Timesheet timesheet);

	void update(Timesheet timesheet);

	void delete(Timesheet timesheet);

	List<Timesheet> findAll();

	Timesheet findByEmpId(Integer empId);
}
