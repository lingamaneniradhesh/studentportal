package com.radhesh.studentportal.service.impl;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.radhesh.studentportal.dao.StudentDAO;
import com.radhesh.studentportal.model.Student;

public class StudentServiceImplTest {

	@Mock
	StudentDAO dao;

	@InjectMocks
	StudentServiceImpl studentService;

	@Spy
	List<Student> students = new ArrayList<Student>();

	@BeforeClass
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		students = getStudentList();
	}

	@Test
	public void findById() {
		Student student = students.get(0);
		when(dao.findById(anyInt())).thenReturn(student);
		Assert.assertEquals(studentService.findById(student.getId()), student);
	}

	@Test
	public void saveStudent() {
		doNothing().when(dao).save(any(Student.class));
		studentService.save(any(Student.class));
		verify(dao, atLeastOnce()).save(any(Student.class));
	}

	@Test
	public void updateStudent() {
		Student student = students.get(0);
		when(dao.findById(anyInt())).thenReturn(student);
		studentService.update(student);
		verify(dao, atLeastOnce()).findById(anyInt());
	}

	@Test
	public void deleteStudent() {
		Student student = students.get(0);
		doNothing().when(dao).delete(student);
		studentService.deleteByLastName(anyString());
		verify(dao, atLeastOnce()).deleteByLastName(anyString());
	}

	@Test
	public void deleteByLastName() {
		doNothing().when(dao).deleteByLastName(anyString());
		studentService.deleteByLastName(anyString());
		verify(dao, atLeastOnce()).deleteByLastName(anyString());
	}

	@Test
	public void findAllStudents() {
		when(dao.findAllStudents()).thenReturn(students);
		Assert.assertEquals(studentService.findAll(), students);
	}

	@Test
	public void findByLastName() {
		Student student = students.get(0);
		when(dao.findByLastName(anyString())).thenReturn(student);
		Assert.assertEquals(studentService.findByLastName(anyString()), student);
	}

	@Test
	public void findByStartsWith() {
		when(dao.findByStartsWithAnd(anyString(), anyString())).thenReturn(students);
		Assert.assertEquals(studentService.findByStartsWithAnd("B", "D"), students);
	}

	public List<Student> getStudentList() {
		Student e1 = new Student();
		e1.setId(1);
		e1.setFirstName("Bhaskar");
		e1.setLastName("Dabbigodla");
		e1.setDateOfJoining(new LocalDate());

		Student e2 = new Student();
		e2.setId(2);
		e2.setFirstName("Sireesha");
		e2.setLastName("Dabbigodla");
		e2.setDateOfJoining(new LocalDate());

		students.add(e1);
		students.add(e2);
		return students;
	}

}
