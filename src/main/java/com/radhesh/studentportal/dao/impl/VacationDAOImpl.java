package com.radhesh.studentportal.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.radhesh.studentportal.dao.VacationDAO;
import com.radhesh.studentportal.exception.NonNullableFieldException;
import com.radhesh.studentportal.exception.SportalDatabaseException;
import com.radhesh.studentportal.model.Vacation;
import com.radhesh.studentportal.refdata.LeaveType;
import com.radhesh.studentportal.util.DateUtil;

@Repository
public class VacationDAOImpl extends AbstractBaseDAO<Serializable, Vacation> implements VacationDAO {

	private static Logger logger = Logger.getLogger(VacationDAOImpl.class);

	public Vacation findById(LeaveType leaveType) {
		logger.info("Params - leaveType: " + leaveType);
		return get(leaveType);
	}

	public void save(Vacation Vacation) {
		logger.info("Params - Vacation: " + Vacation);
		persist(Vacation);
	}

	public void delete(Vacation vacation) {
		logger.info("Params - vacation: " + vacation);
		super.delete(vacation);
	}

	@SuppressWarnings("unchecked")
	public List<Vacation> findAll() {
		Criteria criteria = createCriteria();
		return (List<Vacation>) criteria.list();
	}

	public Vacation findByEmpId(Integer empId) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("empId", empId));
		return (Vacation) criteria.uniqueResult();
	}

	public Vacation findFutureVacation(String empId) throws NonNullableFieldException, SportalDatabaseException {
		logger.info("Params - empId: " + empId);
		Session session = super.getSession();
		Vacation futureVacation = null;
		try {
			if (StringUtils.hasText(empId)) {
				throw new NonNullableFieldException("empId should not be null.");
			}
			LocalDate currentDate = DateUtil.getCurrentDate();
			String hql = "from Vacation v where v.empId = :empId and v.toDate > :currentDate";
			Query query = session.createQuery(hql);
			query.setParameter("empId", empId);
			query.setParameter("currentDate", currentDate);
			List<Vacation> vacations = query.list();
			if (vacations.size() == 1) {
				futureVacation = vacations.get(0);
			} else if (vacations.size() > 1) {
				throw new SportalDatabaseException("You have more than one future vacation: " + vacations.size());
			}
		} catch (HibernateException e) {
			logger.error(e.getMessage(), e);
			throw new SportalDatabaseException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		logger.info("Return - futureVacation: " + futureVacation);
		return futureVacation;
	}

	public Vacation findCurrentVacation(String empId) throws NonNullableFieldException, SportalDatabaseException {
		logger.info("Params - empId: " + empId);
		Session session = super.getSession();
		Vacation currentVacation = null;
		try {
			if (StringUtils.hasText(empId)) {
				throw new NonNullableFieldException("empId should not be null.");
			}
			LocalDate currentDate = DateUtil.getCurrentDate();
			String hql = "from Vacation v where v.empId = :empId and v.toDate >= :currentDate";
			Query query = session.createQuery(hql);
			query.setParameter("empId", empId);
			query.setParameter("currentDate", currentDate);
			List<Vacation> vacations = query.list();
			if (vacations.size() == 1) {
				currentVacation = vacations.get(0);
			} else if (vacations.size() > 1) {
				throw new SportalDatabaseException("You have more than one current vacation: " + vacations.size());
			}
		} catch (HibernateException e) {
			logger.error(e.getMessage(), e);
			throw new SportalDatabaseException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		logger.info("Return - currentVacation: " + currentVacation);
		return currentVacation;
	}

	public Vacation findCurrentVacation() throws NonNullableFieldException, SportalDatabaseException {
		logger.info("Params - ");
		Session session = super.getSession();
		Vacation currentVacation = null;
		try {
			LocalDate currentDate = DateUtil.getCurrentDate();
			String hql = "from Vacation v where v.toDate >= :currentDate";
			Query query = session.createQuery(hql);
			query.setParameter("currentDate", currentDate);
			List<Vacation> vacations = query.list();
			if (vacations.size() == 1) {
				currentVacation = vacations.get(0);
			} else if (vacations.size() > 1) {
				throw new SportalDatabaseException("You have more than one current vacation: " + vacations.size());
			}
		} catch (HibernateException e) {
			logger.error(e.getMessage(), e);
			throw new SportalDatabaseException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		logger.info("Return - currentVacation: " + currentVacation);
		return currentVacation;
	}

	public List<Vacation> findCurrentVacations() throws NonNullableFieldException, SportalDatabaseException {
		logger.info("Params - ");
		Session session = super.getSession();
		List<Vacation> currentVacations = null;
		try {
			LocalDate currentDate = DateUtil.getCurrentDate();
			String hql = "from Vacation v where v.toDate >= :currentDate";
			Query query = session.createQuery(hql);
			query.setParameter("currentDate", currentDate);
			currentVacations = query.list();
		} catch (HibernateException e) {
			logger.error(e.getMessage(), e);
			throw new SportalDatabaseException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		logger.info("Return - currentVacations: " + currentVacations);
		return currentVacations;
	}

	public List<Vacation> findFutureVacations(String empId) throws NonNullableFieldException, SportalDatabaseException {
		logger.info("Params - empId: " + empId);
		Session session = super.getSession();
		List<Vacation> futureVacations = null;
		try {
			if (StringUtils.hasText(empId)) {
				throw new NonNullableFieldException("empId should not be null.");
			}
			LocalDate currentDate = DateUtil.getCurrentDate();
			String hql = "from Vacation v where v.empId = :empId and v.fromDate > :currentDate";
			Query query = session.createQuery(hql);
			query.setParameter("empId", empId);
			query.setParameter("currentDate", currentDate);
			futureVacations = query.list();
		} catch (HibernateException e) {
			logger.error(e.getMessage(), e);
			throw new SportalDatabaseException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		logger.info("Return - futureVacations: " + futureVacations);
		return futureVacations;
	}

	public List<Vacation> findCurrentOrFutureVacations(String empId)
			throws NonNullableFieldException, SportalDatabaseException {
		logger.info("Params - empId: " + empId);
		Session session = super.getSession();
		List<Vacation> futureVacations = null;
		try {
			if (StringUtils.hasText(empId)) {
				throw new NonNullableFieldException("empId should not be null.");
			}
			LocalDate currentDate = DateUtil.getCurrentDate();
			String hql = "from Vacation v where v.empId = :empId and v.fromDate >= :currentDate";
			Query query = session.createQuery(hql);
			query.setParameter("empId", empId);
			query.setParameter("currentDate", currentDate);
			futureVacations = query.list();
		} catch (HibernateException e) {
			logger.error(e.getMessage(), e);
			throw new SportalDatabaseException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		logger.info("Return - futureVacations: " + futureVacations);
		return futureVacations;
	}

	public List<Vacation> findCurrentOrFutureVacations() throws NonNullableFieldException, SportalDatabaseException {
		logger.info("Params - ");
		Session session = super.getSession();
		List<Vacation> futureVacations = null;
		try {
			LocalDate currentDate = DateUtil.getCurrentDate();
			String hql = "from Vacation v where v.fromDate >= :currentDate";
			Query query = session.createQuery(hql);
			query.setParameter("currentDate", currentDate);
			futureVacations = query.list();
		} catch (HibernateException e) {
			logger.error(e.getMessage(), e);
			throw new SportalDatabaseException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		logger.info("Return - futureVacations: " + futureVacations);
		return futureVacations;
	}

	public List<Vacation> findFutureVacations() throws NonNullableFieldException, SportalDatabaseException {
		logger.info("Params - ");
		Session session = super.getSession();
		List<Vacation> futureVacations = null;
		try {
			LocalDate currentDate = DateUtil.getCurrentDate();
			String hql = "from Vacation v where v.fromDate > :currentDate";
			Query query = session.createQuery(hql);
			query.setParameter("currentDate", currentDate);
			futureVacations = query.list();
		} catch (HibernateException e) {
			logger.error(e.getMessage(), e);
			throw new SportalDatabaseException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		logger.info("Return - futureVacations: " + futureVacations);
		return futureVacations;
	}

	public void deleteFutureVacation(LocalDate fromDate, LocalDate toDate, LeaveType leaveType, Integer empId)
			throws NonNullableFieldException, SportalDatabaseException {
		logger.info("Params - fromDate: " + fromDate + "toDate: " + toDate + "leaveType: " + leaveType + " empId: "
				+ empId);
		if (DateUtil.isDateNull(fromDate) || DateUtil.isDateNull(fromDate) || leaveType != null) {
			throw new NonNullableFieldException("empId or fromDate or toDate or leaveType should not be null.");
		}
		Session session = super.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Vacation foundVacation = (Vacation) session.get(Vacation.class, empId);
			if (foundVacation != null) {
				session.delete(foundVacation);
				transaction.commit();
			} else {
				throw new SportalDatabaseException("No vacation found for fromDate: " + fromDate + " empId: " + empId);
			}
		} catch (HibernateException e) {
			logger.error(e.getMessage(), e);
			if (transaction != null) {
				transaction.rollback();
			}
			throw new SportalDatabaseException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteCurrentOrFutureVacation(LocalDate fromDate, LocalDate toDate, LeaveType leaveType, String empId)
			throws NonNullableFieldException, SportalDatabaseException {
		logger.info("Params - fromDate: " + fromDate + "toDate: " + toDate + "leaveType: " + leaveType + " empId: "
				+ empId);
		// if (DateUtil.isDateNull(fromDate) || DateUtil.isDateNull(fromDate) ||
		// leaveType != null
		// || StringUtil.isEmpty(empId)) {
		// throw new NonNullableFieldException("empId or fromDate or toDate or
		// leaveType should not be null.");
		// }
		// Session session = super.getSession();
		// Transaction transaction = null;
		// try {
		// transaction = session.beginTransaction();
		// VacationPk vacationPk = new VacationPk(fromDate, empId);
		// Vacation foundVacation = (Vacation) session.get(Vacation.class,
		// vacationPk);
		// if (foundVacation != null) {
		// session.delete(foundVacation);
		// transaction.commit();
		// } else {
		// throw new SportalDatabaseException(
		// "No vacation found for fromDate: " + fromDate + " empId: " + empId);
		// }
		// } catch (HibernateException e) {
		// logger.error(e.getMessage(), e);
		// if (transaction != null) {
		// transaction.rollback();
		// }
		// throw new SportalDatabaseException(e);
		// } finally {
		// if (session != null) {
		// session.close();
		// }
		// }
	}

}