package com.radhesh.studentportal.dao.impl;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.radhesh.studentportal.dao.TimeInOutDAO;
import com.radhesh.studentportal.exception.NonNullableFieldException;
import com.radhesh.studentportal.exception.SportalDatabaseException;
import com.radhesh.studentportal.model.TimeInOut;
import com.radhesh.studentportal.util.DateUtil;

@Repository
public class TimeInOutDAOImpl extends AbstractBaseDAO<Serializable, TimeInOut> implements TimeInOutDAO {

	private static Logger logger = Logger.getLogger(TimeInOutDAOImpl.class);

	public TimeInOut findById(LocalDate ioDate) {
		logger.info("Params - ioDate: " + ioDate);
		return get(ioDate);
	}

	public void save(TimeInOut TimeInOut) {
		logger.info("Params - TimeInOut: " + TimeInOut);
		persist(TimeInOut);
	}

	public void delete(TimeInOut TimeInOut) {
		logger.info("Params - TimeInOut: " + TimeInOut);
		super.delete(TimeInOut);
	}

	@SuppressWarnings("unchecked")
	public List<TimeInOut> findAll() {
		Criteria criteria = createCriteria();
		return (List<TimeInOut>) criteria.list();
	}

	public TimeInOut findByEmpId(Integer empId) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("empId", empId));
		return (TimeInOut) criteria.uniqueResult();
	}

	public TimeInOut findByDateAndempId(LocalDate ioDate, String empId) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("ioDate", ioDate));
		criteria.add(Restrictions.eq("empId", empId));
		return (TimeInOut) criteria.uniqueResult();
	}

	public void recordTimeIn() throws NonNullableFieldException, SportalDatabaseException {
		Calendar currentCalendar = Calendar.getInstance();
		LocalDate currentDate = DateUtil.getCurrentDate();
		LocalTime currentTime = LocalTime.fromCalendarFields(currentCalendar);
		TimeInOut timeInOut = new TimeInOut(currentDate, currentTime, null);
		save(timeInOut);
	}

	public void recordTimeOut(String empId) throws NonNullableFieldException, SportalDatabaseException {
		logger.info("Params - empId: " + empId);
		Calendar currentCalendar = Calendar.getInstance();
		LocalDate currentDate = DateUtil.getCurrentDate();
		TimeInOut timeInOut = findByDateAndempId(currentDate, empId);
		if (timeInOut == null) {
			throw new NonNullableFieldException(
					"There is no InTime for" + "this employee " + empId + " today: " + currentDate);
		}
		LocalTime currentTime = LocalTime.fromCalendarFields(currentCalendar);
		timeInOut.setOutTime(currentTime);
		save(timeInOut);
	}

	public TimeInOut findCurrentTimeInOut(String empId) throws NonNullableFieldException, SportalDatabaseException {
		logger.info("Params - empId: " + empId);
		Session session = super.getSession();
		TimeInOut currentTimeInOut = null;
		try {
			if (StringUtils.hasText(empId)) {
				throw new NonNullableFieldException("TimeInOut empId should not be null.");
			}
			LocalDate currentDate = DateUtil.getCurrentDate();
			String hql = "from TimeInOut t where t.empId = :empId and t.ioDate = :ioDate";
			Query query = session.createQuery(hql);
			query.setParameter("empId", empId);
			query.setParameter("ioDate", currentDate);
			List<TimeInOut> ioDates = query.list();
			if (ioDates.size() == 1) {
				currentTimeInOut = ioDates.get(0);
			} else if (ioDates.size() > 1) {
				throw new SportalDatabaseException("You have more than one current TimeInOut: " + ioDates.size());
			}
		} catch (HibernateException e) {
			logger.error(e.getMessage(), e);
			throw new SportalDatabaseException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		logger.info("Return - currentTimeInOut: " + currentTimeInOut);
		return currentTimeInOut;
	}

	public List<TimeInOut> findCurrentTimeInOuts() throws NonNullableFieldException, SportalDatabaseException {
		logger.info("Params -");
		Session session = super.getSession();
		List<TimeInOut> currentTimeInOuts = null;
		try {
			LocalDate currentDate = DateUtil.getCurrentDate();
			String hql = "from TimeInOut t where t.ioDate = :ioDate order by t.inTime";
			Query query = session.createQuery(hql);
			query.setParameter("ioDate", currentDate);
			currentTimeInOuts = query.list();
		} catch (HibernateException e) {
			logger.error(e.getMessage(), e);
			throw new SportalDatabaseException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		logger.info("Return - currentTimeInOuts: " + currentTimeInOuts);
		return currentTimeInOuts;
	}

	public List<TimeInOut> findTimeInOutRange(LocalDate fromDate, LocalDate toDate, String empId)
			throws NonNullableFieldException, SportalDatabaseException {
		logger.info("Params - fromDate: " + fromDate + " toDate: " + toDate + " empId:" + empId);
		Session session = super.getSession();
		List<TimeInOut> timeInOuts = null;
		try {
			if (DateUtil.isDateNull(fromDate) || DateUtil.isDateNull(toDate) || StringUtils.hasText(empId)) {
				throw new NonNullableFieldException("fromDate or toDate or empId should not be null.");
			}
			String hql = "from TimeInOut t where t.empId = :empId and t.ioDate between :fromDate and :toDate";
			Query query = session.createQuery(hql);
			query.setParameter("empId", empId);
			query.setParameter("fromDate", fromDate);
			query.setParameter("toDate", toDate);
			timeInOuts = query.list();
		} catch (HibernateException e) {
			logger.error(e.getMessage(), e);
			throw new SportalDatabaseException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		logger.info("Return - timeInOuts: " + timeInOuts);
		return timeInOuts;
	}

	public List<TimeInOut> findTimeInOutRange(LocalDate fromDate, LocalDate toDate)
			throws NonNullableFieldException, SportalDatabaseException {
		logger.info("Params - fromDate: " + fromDate + " toDate: " + toDate);
		Session session = super.getSession();
		List<TimeInOut> timeInOutRanges = null;
		try {
			if (DateUtil.isDateNull(fromDate) || DateUtil.isDateNull(toDate)) {
				throw new NonNullableFieldException("TimeInOut fromdate should not be null.");
			}
			String hql = "from TimeInOut t where t.ioDate between :fromDate and :toDate";
			Query query = session.createQuery(hql);
			query.setParameter("fromDate", fromDate);
			query.setParameter("toDate", toDate);
			timeInOutRanges = query.list();
		} catch (HibernateException e) {
			logger.error(e.getMessage(), e);
			throw new SportalDatabaseException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		logger.info("Return - timeInOutRanges: " + timeInOutRanges);
		return timeInOutRanges;
	}

}