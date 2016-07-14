package com.radhesh.studentportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.radhesh.studentportal.dao.StudentDAO;
import com.radhesh.studentportal.model.Student;
import com.radhesh.studentportal.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO dao;

	public Student findById(Integer id) {
		return dao.findById(id);
	}

	public List<Student> findByStartsWithOr(Student student) {
		return dao.findByStartsWithOr(student);
	}

	public void save(Student student) {
		dao.save(student);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate
	 * update explicitly. Just fetch the entity from db and update it with
	 * proper values within transaction. It will be updated in db once
	 * transaction ends.
	 */
	public void update(Student student) {
		Student entity = dao.findById(student.getId());
		if (entity != null) {
			entity.setFirstName(student.getFirstName());
			entity.setMiddleName(student.getMiddleName());
			entity.setLastName(student.getLastName());
			entity.setEmail(student.getEmail());
			entity.setDateOfBirth(student.getDateOfBirth());
			entity.setDateOfJoining(student.getDateOfJoining());
			entity.setDateLeft(student.getDateLeft());
		}
	}

	public void delete(Student student) {
		dao.delete(student);
	}

	public void deleteByLastName(String lastName) {
		dao.deleteByLastName(lastName);
	}

	public List<Student> findAll() {
		return dao.findAllStudents();
	}

	public Student findByLastName(String lastName) {
		return dao.findByLastName(lastName);
	}

	@Override
	public List<Student> findByStartsWithAnd(String firstName, String lastName) {
		return dao.findByStartsWithAnd(firstName, lastName);

	}
}
