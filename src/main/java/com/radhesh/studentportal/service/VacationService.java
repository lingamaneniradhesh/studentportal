package com.radhesh.studentportal.service;

import java.util.List;

import com.radhesh.studentportal.model.Vacation;
import com.radhesh.studentportal.refdata.LeaveType;

public interface VacationService {

	Vacation findById(LeaveType leaveType);

	void save(Vacation vacation);

	void update(Vacation vacation);

	void delete(Vacation vacation);

	List<Vacation> findAll();

	Vacation findByEmpId(Integer empId);
}
