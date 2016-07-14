package com.radhesh.studentportal.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.radhesh.studentportal.dao.ContactDAO;
import com.radhesh.studentportal.exception.NonNullableFieldException;
import com.radhesh.studentportal.exception.SportalDatabaseException;
import com.radhesh.studentportal.model.Contact;
import com.radhesh.studentportal.util.DateUtil;

@Repository
public class ContactDAOImpl extends AbstractBaseDAO<Integer, Contact> implements ContactDAO {

	private static Logger logger = Logger.getLogger(ContactDAOImpl.class);

	public Contact findById(Integer id) {
		logger.info("Params - id: " + id);
		return get(id);
	}

	@SuppressWarnings("unchecked")
	public List<Contact> findByStartsWithOr(Contact contact) {
		logger.info("Params - contact: " + contact);
		Criteria criteria = createCriteria();
		Criterion firstNameCriterion = null;
		if (StringUtils.hasText(contact.getFirstName())) {
			firstNameCriterion = Restrictions.ilike("firstName", contact.getFirstName() + "%");
		}
		Criterion lastNameCriterion = null;
		if (StringUtils.hasText(contact.getLastName())) {
			lastNameCriterion = Restrictions.ilike("lastName", contact.getLastName() + "%");
		}

		if (firstNameCriterion != null && lastNameCriterion != null) {
			LogicalExpression orContact = Restrictions.or(firstNameCriterion, lastNameCriterion);
			criteria.add(orContact);
		} else if (firstNameCriterion != null) {
			criteria.add(firstNameCriterion);
		} else if (lastNameCriterion != null) {
			criteria.add(lastNameCriterion);
		}

		return criteria.list();
	}

	public void save(Contact contact) {
		logger.info("Params - contact: " + contact);
		persist(contact);
	}

	public void delete(Contact contact) {
		logger.info("Params - contact: " + contact);
		super.delete(contact);
	}

	@SuppressWarnings("unchecked")
	public List<Contact> findAll() {
		Criteria criteria = createCriteria();
		return (List<Contact>) criteria.list();
	}

	public List<Contact> findContactRange(LocalDate fromDate, LocalDate toDate)
			throws NonNullableFieldException, SportalDatabaseException {
		logger.info("Params - fromDate: " + fromDate + " toDate: " + toDate);
		Session session = super.getSession();
		List<Contact> contacts = null;
		try {
			if (DateUtil.isDateNull(fromDate) || DateUtil.isDateNull(toDate)) {
				throw new NonNullableFieldException("fromDate toDate should not be null.");
			}
			String hql = "from Contact a where a.fromDate = :fromDate and a.toDate = :toDate";
			Query query = session.createQuery(hql);
			query.setParameter("fromDate", fromDate);
			query.setParameter("toDate", toDate);
			contacts = query.list();
		} catch (HibernateException e) {
			logger.error(e.getMessage(), e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		logger.info("Return - contacts: " + contacts);
		return contacts;
	}

}
