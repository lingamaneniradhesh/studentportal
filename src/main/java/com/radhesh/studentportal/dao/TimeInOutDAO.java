package com.radhesh.studentportal.dao;

import java.util.List;

import org.joda.time.LocalDate;

import com.radhesh.studentportal.model.TimeInOut;

public interface TimeInOutDAO {

	TimeInOut findById(LocalDate ioDate);

	void save(TimeInOut timeInOut);

	void delete(TimeInOut timeInOut);

	List<TimeInOut> findAll();

	TimeInOut findByEmpId(Integer empId);
}
