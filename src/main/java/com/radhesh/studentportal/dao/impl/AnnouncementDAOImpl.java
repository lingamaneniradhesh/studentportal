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

import com.radhesh.studentportal.dao.AnnouncementDAO;
import com.radhesh.studentportal.exception.NonNullableFieldException;
import com.radhesh.studentportal.exception.SportalDatabaseException;
import com.radhesh.studentportal.model.Announcement;
import com.radhesh.studentportal.util.DateUtil;

@Repository
public class AnnouncementDAOImpl extends AbstractBaseDAO<Integer, Announcement> implements AnnouncementDAO {

	private static Logger logger = Logger.getLogger(AnnouncementDAOImpl.class);

	public Announcement findById(Integer id) {
		logger.info("Params - id: " + id);
		return get(id);
	}

	@SuppressWarnings("unchecked")
	public List<Announcement> findByStartsWithOr(Announcement announcement) {
		logger.info("Params - announcement: " + announcement);
		Criteria criteria = createCriteria();
		Criterion titleCriterion = null;
		if (StringUtils.hasText(announcement.getTitle())) {
			titleCriterion = Restrictions.ilike("title", announcement.getTitle() + "%");
		}
		Criterion descriptionCriterion = null;
		if (StringUtils.hasText(announcement.getDescription())) {
			descriptionCriterion = Restrictions.ilike("description", announcement.getDescription() + "%");
		}

		if (titleCriterion != null && descriptionCriterion != null) {
			LogicalExpression orAnnouncement = Restrictions.or(titleCriterion, descriptionCriterion);
			criteria.add(orAnnouncement);
		} else if (titleCriterion != null) {
			criteria.add(titleCriterion);
		} else if (descriptionCriterion != null) {
			criteria.add(descriptionCriterion);
		}

		return criteria.list();
	}

	public void save(Announcement announcement) {
		logger.info("Params - announcement: " + announcement);
		persist(announcement);
	}

	public void delete(Announcement announcement) {
		logger.info("Params - announcement: " + announcement);
		super.delete(announcement);
	}

	@SuppressWarnings("unchecked")
	public List<Announcement> findAll() {
		Criteria criteria = createCriteria();
		return (List<Announcement>) criteria.list();
	}

	public Announcement findByEmpId(Integer empId) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("empId", empId));
		return (Announcement) criteria.uniqueResult();
	}

	public List<Announcement> findAnnouncementRange(LocalDate fromDate, LocalDate toDate)
			throws NonNullableFieldException, SportalDatabaseException {
		logger.info("Params - fromDate: " + fromDate + " toDate: " + toDate);
		Session session = super.getSession();
		List<Announcement> announcements = null;
		try {
			if (DateUtil.isDateNull(fromDate) || DateUtil.isDateNull(toDate)) {
				throw new NonNullableFieldException("fromDate toDate should not be null.");
			}
			String hql = "from Announcement a where a.fromDate = :fromDate and a.toDate = :toDate";
			Query query = session.createQuery(hql);
			query.setParameter("fromDate", fromDate);
			query.setParameter("toDate", toDate);
			announcements = query.list();
		} catch (HibernateException e) {
			logger.error(e.getMessage(), e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		logger.info("Return - announcements: " + announcements);
		return announcements;
	}

	public Announcement findCurrentAnnouncement(Integer empId)
			throws NonNullableFieldException, SportalDatabaseException {
		logger.info("Params - empId: " + empId);
		Session session = super.getSession();
		Announcement currentAnnouncement = null;
		try {
			LocalDate currentDate = DateUtil.getCurrentDate();
			String hql = "from Announcement a where a.empId = :empId and a.toDate >= :currentDate";
			Query query = session.createQuery(hql);
			query.setParameter("empId", empId);
			query.setParameter("currentDate", currentDate);
			List<Announcement> announcements = query.list();
			if (announcements.size() == 1) {
				currentAnnouncement = announcements.get(0);
			} else if (announcements.size() > 1) {
				throw new SportalDatabaseException(
						"You have more than one current announcement: " + announcements.size());
			}
		} catch (HibernateException e) {
			logger.error(e.getMessage(), e);
			throw new SportalDatabaseException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		logger.info("Return - currentAnnouncement: " + currentAnnouncement);
		return currentAnnouncement;
	}

	public List<Announcement> findCurrentAnnouncements() throws NonNullableFieldException, SportalDatabaseException {
		logger.info("Params - ");
		Session session = super.getSession();
		List<Announcement> currentAnnouncements = null;
		try {
			LocalDate currentDate = DateUtil.getCurrentDate();
			String hql = "from Announcement a where a.fromDate <= :cDate and"
					+ " (a.toDate is null or a.toDate >= :cDate)";
			Query query = session.createQuery(hql);
			query.setParameter("cDate", currentDate);
			currentAnnouncements = query.list();
		} catch (HibernateException e) {
			logger.error(e.getMessage(), e);
			throw new SportalDatabaseException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		logger.info("Return - currentAnnouncements: " + currentAnnouncements);
		return currentAnnouncements;
	}

}
