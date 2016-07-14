package com.radhesh.studentportal.dao;

import java.util.List;

import com.radhesh.studentportal.model.Vacation;
import com.radhesh.studentportal.refdata.LeaveType;

public interface VacationDAO {

	Vacation findById(LeaveType leaveType);

	void save(Vacation vacation);

	void delete(Vacation vacation);

	List<Vacation> findAll();

	Vacation findByEmpId(Integer empId);
}
