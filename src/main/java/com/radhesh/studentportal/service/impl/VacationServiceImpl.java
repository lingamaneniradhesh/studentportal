package com.radhesh.studentportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.radhesh.studentportal.dao.VacationDAO;
import com.radhesh.studentportal.model.Vacation;
import com.radhesh.studentportal.refdata.LeaveType;
import com.radhesh.studentportal.service.VacationService;

@Service
@Transactional
public class VacationServiceImpl implements VacationService {

	@Autowired
	private VacationDAO vacationDAO;

	public Vacation findById(LeaveType leaveType) {
		return vacationDAO.findById(leaveType);
	}

	public void save(Vacation vacation) {
		vacationDAO.save(vacation);
	}

	public void update(Vacation vacation) {
		Vacation entity = vacationDAO.findById(vacation.getLeaveType());
		if (entity != null) {
			entity.setFromDate(vacation.getFromDate());
			entity.setToDate(vacation.getToDate());
			entity.setLeaveType(vacation.getLeaveType());
		}
	}

	public void delete(Vacation vacation) {
		vacationDAO.delete(vacation);
	}

	public List<Vacation> findAll() {
		return vacationDAO.findAll();
	}

	public Vacation findByEmpId(Integer empId) {
		return vacationDAO.findByEmpId(empId);
	}
}
