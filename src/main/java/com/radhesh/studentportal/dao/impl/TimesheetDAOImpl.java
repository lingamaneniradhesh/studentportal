package com.radhesh.studentportal.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.radhesh.studentportal.dao.TimesheetDAO;
import com.radhesh.studentportal.exception.NonNullableFieldException;
import com.radhesh.studentportal.exception.SportalDatabaseException;
import com.radhesh.studentportal.model.Timesheet;
import com.radhesh.studentportal.util.DateUtil;

@Repository
public class TimesheetDAOImpl extends AbstractBaseDAO<Integer, Timesheet> implements TimesheetDAO {

	private static Logger logger = Logger.getLogger(TimesheetDAOImpl.class);

	public Timesheet findById(Integer id) {
		logger.info("Params - id: " + id);
		return get(id);
	}

	public void save(Timesheet timesheet) {
		logger.info("Params - timesheet: " + timesheet);
		persist(timesheet);
	}

	public void delete(Timesheet timesheet) {
		logger.info("Params - timesheet: " + timesheet);
		super.delete(timesheet);
	}

	@SuppressWarnings("unchecked")
	public List<Timesheet> findAll() {
		Criteria criteria = createCriteria();
		return (List<Timesheet>) criteria.list();
	}

	public Timesheet findByEmpId(Integer empId) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("empId", empId));
		return (Timesheet) criteria.uniqueResult();
	}

	public List<Timesheet> findCurrentTimesheet(LocalDate tsDate, String task, Integer empId)
			throws NonNullableFieldException, SportalDatabaseException {
		logger.info("Params - empId: " + empId + " tsDate: " + tsDate + " task: " + task);
		Session session = super.getSession();
		List<Timesheet> timesheets = null;
		try {
			if (DateUtil.isDateNull(tsDate) || StringUtils.hasText(task)) {
				throw new NonNullableFieldException("empId or tsDate or task should not be null.");
			}
			Timesheet foundCurrentTimesheet = (Timesheet) session.get(Timesheet.class, empId);
			logger.info("Return - foundCurrentTimesheet: " + foundCurrentTimesheet);
			return timesheets;
		} catch (HibernateException e) {
			logger.error(e.getMessage(), e);
			throw new SportalDatabaseException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}