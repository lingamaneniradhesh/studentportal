package com.radhesh.studentportal.dao;

import java.util.List;

import com.radhesh.studentportal.model.Timesheet;

public interface TimesheetDAO {

	Timesheet findById(Integer id);

	void save(Timesheet timesheet);

	void delete(Timesheet timesheet);

	List<Timesheet> findAll();

	Timesheet findByEmpId(Integer empId);
}
