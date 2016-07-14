package com.radhesh.studentportal.service;

import java.util.List;

import org.joda.time.LocalDate;

import com.radhesh.studentportal.model.TimeInOut;

public interface TimeInOutService {

	TimeInOut findById(LocalDate ioDate);

	void save(TimeInOut timeInOut);

	void update(TimeInOut timeInOut);

	void delete(TimeInOut timeInOut);

	List<TimeInOut> findAll();

	TimeInOut findByEmpId(Integer empId);
}
