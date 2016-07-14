package com.radhesh.studentportal.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.radhesh.studentportal.dao.StudentDAO;
import com.radhesh.studentportal.model.Student;

@Repository
public class StudentDAOImpl extends AbstractBaseDAO<Integer, Student> implements StudentDAO {

	private static Logger logger = Logger.getLogger(StudentDAOImpl.class);

	public Student findById(Integer id) {
		return get(id);
	}

	@SuppressWarnings("unchecked")
	public List<Student> findByStartsWithOr(Student student) {
		logger.info("Params - student: " + student);
		Criteria criteria = createCriteria();
		Criterion firstNameCriterion = null;
		if (StringUtils.hasText(student.getFirstName())) {
			firstNameCriterion = Restrictions.ilike("firstName", student.getFirstName() + "%");
		}
		Criterion lastNameCriterion = null;
		if (StringUtils.hasText(student.getLastName())) {
			lastNameCriterion = Restrictions.ilike("lastName", student.getLastName() + "%");
		}

		if (firstNameCriterion != null && lastNameCriterion != null) {
			LogicalExpression orStudent = Restrictions.or(firstNameCriterion, lastNameCriterion);
			criteria.add(orStudent);
		} else if (firstNameCriterion != null) {
			criteria.add(firstNameCriterion);
		} else if (lastNameCriterion != null) {
			criteria.add(lastNameCriterion);
		}

		return criteria.list();
	}

	public void save(Student student) {
		persist(student);
	}

	public void delete(Student student) {
		super.delete(student);
	}

	public void deleteByLastName(String lastName) {
		// This is an example for HQL query
		Query query = getSession().createQuery("delete from Student where lastName = :l");
		//Note: Need to use createSQLQuery method for executing SQL queries directly
		query.setParameter("l", lastName);
		int deletedCount = query.executeUpdate();
		logger.info("Number of records deleted: " + deletedCount);
	}

	@SuppressWarnings("unchecked")
	public List<Student> findAllStudents() {
		Criteria criteria = createCriteria();
		return (List<Student>) criteria.list();
	}

	public Student findByLastName(String lastName) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("lastName", lastName));
		return (Student) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Student> findByStartsWithAnd(String firstName, String lastName) {
		Criteria criteria = createCriteria();

		Criterion firstNameCriterion = Restrictions.ilike("firstName", firstName + "%");
		Criterion lastNameCriterion = Restrictions.ilike("lastName", lastName + "%");

		LogicalExpression firstNameAndLastName = Restrictions.and(firstNameCriterion, lastNameCriterion);
		criteria.add(firstNameAndLastName);
		return (List<Student>) criteria.list();
	}
}