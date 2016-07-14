package com.radhesh.studentportal.dao.impl;

import java.util.List;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.radhesh.studentportal.dao.EntityDaoImplTest;
import com.radhesh.studentportal.dao.StudentDAO;
import com.radhesh.studentportal.model.Student;

import junit.framework.TestCase;

public class StudentDaoImplTest extends EntityDaoImplTest {

	@Autowired
	StudentDAO studentDAO;

	@Override
	protected IDataSet getDataSet() throws Exception {
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Student.xml"));
		return dataSet;
	}

	/*
	 * In case you need multiple datasets (mapping different tables) and you do
	 * prefer to keep them in separate XML's
	 * 
	 * @Override protected IDataSet getDataSet() throws Exception { IDataSet[]
	 * datasets = new IDataSet[] { new
	 * FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream(
	 * "Student.xml")), new
	 * FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream(
	 * "Benefits.xml")), new
	 * FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream(
	 * "Departements.xml")) }; return new CompositeDataSet(datasets); }
	 */

	@Test
	public void findById() {
		TestCase.assertNotNull(studentDAO.findById(1));
		TestCase.assertNull(studentDAO.findById(3));
	}

	@Test
	public void saveStudent() {
		studentDAO.save(getSampleStudent());
		TestCase.assertEquals(studentDAO.findAllStudents().size(), 3);
	}

//	@Test
//	public void deleteStudentByLastName() {
//		studentDAO.deleteByLastName("GANAPA");
//		TestCase.assertEquals(studentDAO.findAllStudents().size(), 1);
//	}

//	@Test
//	public void deleteStudentByInvalidLastName() {
//		studentDAO.deleteByLastName("Tendulkar");
//		TestCase.assertEquals(studentDAO.findAllStudents().size(), 2);
//	}

	@Test
	public void findAllStudents() {
		TestCase.assertEquals(studentDAO.findAllStudents().size(), 2);
	}

	@Test
	public void findStudentByLastName() {
		TestCase.assertNotNull(studentDAO.findByLastName("GANAPA"));
		TestCase.assertNull(studentDAO.findByLastName("Dabbigodla"));
	}

	@Test
	public void findByStartsWithNonExisting() {
		List<Student> students = studentDAO.findByStartsWithAnd("B", "D");
		TestCase.assertEquals(students.size(), 0);
	}

	@Test
	public void findByStartsWith() {
		List<Student> students = studentDAO.findByStartsWithAnd("S", "G");
		TestCase.assertEquals(students.size(), 1);
	}

	public Student getSampleStudent() {
		Student student = new Student();
		student.setFirstName("Ishitha");
		student.setLastName("Dabbigodla");
		student.setDateOfBirth(new LocalDate());
		student.setDateOfJoining(new LocalDate());
		return student;
	}

}
