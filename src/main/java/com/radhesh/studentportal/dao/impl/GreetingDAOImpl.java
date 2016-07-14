package com.radhesh.studentportal.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Repository;

import com.radhesh.studentportal.dao.GreetingDAO;
import com.radhesh.studentportal.exception.NonNullableFieldException;
import com.radhesh.studentportal.exception.SportalDatabaseException;
import com.radhesh.studentportal.model.Greeting;
import com.radhesh.studentportal.util.DateUtil;

@Repository
public class GreetingDAOImpl extends AbstractBaseDAO<Serializable, Greeting> implements GreetingDAO {

	private static Logger logger = Logger.getLogger(GreetingDAOImpl.class);

	public Greeting findById(String message) {
		logger.info("Params - message: " + message);
		return get(message);
	}

	public void save(Greeting greeting) {
		logger.info("Params - greeting: " + greeting);
		persist(greeting);
	}

	public void delete(Greeting greeting) {
		logger.info("Params - greeting: " + greeting);
		super.delete(greeting);
	}

	@SuppressWarnings("unchecked")
	public List<Greeting> findAll() {
		Criteria criteria = createCriteria();
		return (List<Greeting>) criteria.list();
	}

	public Greeting findByEmpId(Integer empId) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("empId", empId));
		return (Greeting) criteria.uniqueResult();
	}

	public Greeting findCurrentGreeting(Integer empId) throws NonNullableFieldException, SportalDatabaseException {
		logger.info("Params - empId: " + empId);
		Session session = super.getSession();
		Greeting currentGreeting = null;
		try {
			LocalDate currentDate = DateUtil.getCurrentDate();
			String hql = "from Greeting g where g.empId = :empId and g.toDate >= :currentDate";
			Query query = session.createQuery(hql);
			query.setParameter("empId", empId);
			query.setParameter("currentDate", currentDate);
			List<Greeting> greetings = query.list();
			if (greetings.size() == 1) {
				currentGreeting = greetings.get(0);
			} else if (greetings.size() > 1) {
				throw new SportalDatabaseException("You have more than one current vacation: " + greetings.size());
			}
		} catch (HibernateException e) {
			logger.error(e.getMessage(), e);
			throw new SportalDatabaseException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		logger.info("Return - currentGreeting: " + currentGreeting);
		return currentGreeting;
	}

	public List<Greeting> findCurrentGreetings() throws NonNullableFieldException, SportalDatabaseException {
		logger.info("Params - ");
		Session session = super.getSession();
		List<Greeting> currentGreetings = null;
		try {
			LocalDate currentDate = DateUtil.getCurrentDate();
			String hql = "from Greeting g where g.fromDate <= :cDate and" + " (g.toDate is null or g.toDate >= :cDate)";
			Query query = session.createQuery(hql);
			query.setParameter("cDate", currentDate);
			currentGreetings = query.list();
		} catch (HibernateException e) {
			logger.error(e.getMessage(), e);
			throw new SportalDatabaseException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		logger.info("Return - currentGreetings: " + currentGreetings);
		return currentGreetings;
	}

	public List<Greeting> listOfGreetings(LocalDate fromDate) throws SportalDatabaseException {
		logger.info("");
		Session session = super.getSession();
		List<Greeting> greetings = null;
		try {
			greetings = session.createQuery("from Greeting g where g.empId like '" + fromDate + "'").list();
		} catch (HibernateException e) {
			logger.error(e.getMessage(), e);
			greetings = new ArrayList<Greeting>();
			throw new SportalDatabaseException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		logger.info("Return - greetings: " + greetings);
		return greetings;
	}

	public List<Greeting> findTimeGreetingRange(LocalDate fromDate, LocalDate toDate)
			throws NonNullableFieldException, SportalDatabaseException {
		logger.info("Params - fromDate: " + fromDate + " toDate: " + toDate);
		Session session = super.getSession();
		List<Greeting> greetings = null;
		try {
			if (DateUtil.isDateNull(fromDate) || DateUtil.isDateNull(toDate)) {
				throw new NonNullableFieldException("Greeting empId should not be null.");
			}
			String hql = "from Greeting g where g.fromDate = :fromDate " + "and g.toDate = :toDate";
			Query query = session.createQuery(hql);
			query.setParameter("fromDate", fromDate);
			query.setParameter("toDate", toDate);
			greetings = query.list();
		} catch (HibernateException e) {
			logger.error(e.getMessage(), e);
			throw new SportalDatabaseException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		logger.info("Return - greetings: " + greetings);
		return greetings;
	}

}