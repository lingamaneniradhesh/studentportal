package com.radhesh.studentportal.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.context.MessageSource;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.radhesh.studentportal.model.Student;
import com.radhesh.studentportal.service.StudentService;
import com.radhesh.studentportal.util.ViewNameConstants;

public class StudentControllerTest implements ViewNameConstants {

	@Mock
	StudentService service;

	@Mock
	MessageSource message;

	@InjectMocks
	StudentController studentController;

	@Spy
	List<Student> students = new ArrayList<Student>();

	@Spy
	ModelMap model;

	@Mock
	BindingResult result;

	@BeforeClass
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		students = getStudentList();
	}

	@Test
	public void listStudents() {
//		when(service.findAllStudents()).thenReturn(students);
//		Assert.assertEquals(studentController.listStudents(model), STUDENTS_JSP);
//		Assert.assertEquals(model.get("students"), students);
//		verify(service, atLeastOnce()).findAllStudents();
	}

	@Test
	public void newStudent() {
		Assert.assertEquals(studentController.create(model), CREATE_STUDENT_JSP);
		Assert.assertNotNull(model.get("student"));
		Assert.assertFalse((Boolean) model.get("edit"));
		Assert.assertEquals(((Student) model.get("student")).getId(), null);
	}

	@Test
	public void saveStudentWithValidationError() {
		when(result.hasErrors()).thenReturn(true);
		doNothing().when(service).save(any(Student.class));
		Assert.assertEquals(studentController.save(students.get(0), result, model), UPDATE_STUDENT_JSP);
	}

//	@Test
//	public void saveStudentWithValidationErrorNonUniqueSSN() {
//		when(result.hasErrors()).thenReturn(false);
//		when(service.isStudentLastNameUnique(anyInt(), anyString())).thenReturn(false);
//		Assert.assertEquals(studentController.saveStudent(students.get(0), result, model), "registration");
//	}

//	@Test
//	public void saveStudentWithSuccess() {
//		when(result.hasErrors()).thenReturn(false);
//		when(service.isStudentCourseUnique(anyInt(), anyString())).thenReturn(true);
//		doNothing().when(service).saveStudent(any(Student.class));
//		Assert.assertEquals(studentController.saveStudent(students.get(0), result, model), "success");
//		Assert.assertEquals(model.get("success"), "Student Bhaskar Dabbigodla registered successfully");
//	}

//	@Test
//	public void editStudent() {
//		Student student = students.get(0);
//		when(service.findById(student.getId())).thenReturn(student);
//		Assert.assertEquals(studentController.update(student, result,  model, ""), STUDENT_REDIRECT_LIST);
//		Assert.assertNotNull(model.get("student"));
//		Assert.assertTrue((Boolean) model.get("edit"));
//		Assert.assertEquals(((Student) model.get("student")).getId(), new Integer(1));
//	}

	@Test
	public void updateStudentWithValidationError() {
		when(result.hasErrors()).thenReturn(true);
		doNothing().when(service).update(any(Student.class));
		Assert.assertEquals(studentController.update(students.get(0), result, model, ""), UPDATE_STUDENT_JSP);
	}

//	@Test
//	public void updateStudentWithValidationErrorNonUniqueSSN() {
//		when(result.hasErrors()).thenReturn(false);
//		when(service.isStudentLastNameUnique(anyInt(), anyString())).thenReturn(false);
//		Assert.assertEquals(studentController.updateStudent(students.get(0), result, model, ""), REGISTER_STUDENT_JSP);
//	}

//	@Test
//	public void updateStudentWithSuccess() {
//		when(result.hasErrors()).thenReturn(false);
//		when(service.isStudentLastNameUnique(anyInt(), anyString())).thenReturn(true);
//		doNothing().when(service).updateStudent(any(Student.class));
//		Assert.assertEquals(studentController.updateStudent(students.get(0), result, model, ""), "success");
//		Assert.assertEquals(model.get("success"), "Student Bhaskar Dabbigodla updated successfully");
//	}

	@Test
	public void deleteStudent() {
		Student student = students.get(0);
		doNothing().when(service).delete(student);
		Assert.assertEquals(studentController.delete("123"), STUDENT_REDIRECT_LIST);
	}

	@Test
	public void deleteStudentByLastName() {
		doNothing().when(service).deleteByLastName(anyString());
		Assert.assertEquals(studentController.delete("123"), STUDENT_REDIRECT_LIST);
	}

	public List<Student> getStudentList() {
		Student e1 = new Student();
		e1.setId(1);
		e1.setFirstName("Bhaskar");
		e1.setLastName("Dabbigodla");
		e1.setDateOfBirth(new LocalDate());
		e1.setDateOfJoining(new LocalDate());

		Student e2 = new Student();
		e2.setId(2);
		e2.setFirstName("Sireesha");
		e2.setLastName("Ganapa");
		e2.setDateOfBirth(new LocalDate());
		e2.setDateOfJoining(new LocalDate());

		students.add(e1);
		students.add(e2);
		return students;
	}
}
