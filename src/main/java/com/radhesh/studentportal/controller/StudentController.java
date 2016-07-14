package com.radhesh.studentportal.controller;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.radhesh.studentportal.model.Student;
import com.radhesh.studentportal.service.StudentService;
import com.radhesh.studentportal.util.StudentComparator;
import com.radhesh.studentportal.util.ViewNameConstants;

@Controller
@RequestMapping("/student")
public class StudentController implements ViewNameConstants {

	private static Logger logger = Logger.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = { "/create" }, method = RequestMethod.GET)
	public String create(ModelMap model) {
		Student student = new Student();
		model.addAttribute("student", student);
		model.addAttribute("edit", false);
		return UPDATE_STUDENT_JSP;
	}

	@RequestMapping(value = { "/create" }, method = RequestMethod.POST)
	public String save(@Valid final Student student, final BindingResult result, final ModelMap model) {

		if (result.hasErrors()) {
			return CREATE_STUDENT_JSP;
		}
		studentService.save(student);
		return STUDENT_REDIRECT_LIST;
	}

	@RequestMapping(value = { "/edit-{id}-student" }, method = RequestMethod.GET)
	public String show(@PathVariable String id, ModelMap model) {
		logger.info("studnetId: " + id);
		Student student = studentService.findById(new Integer(id));
		model.addAttribute("student", student);
		model.addAttribute("edit", true);
		return UPDATE_STUDENT_JSP;
	}

	@RequestMapping(value = { "/edit-{id}-student" }, method = RequestMethod.POST)
	public String update(@Valid Student student, BindingResult result, ModelMap model, @PathVariable String id) {

		if (result.hasErrors()) {
			return UPDATE_STUDENT_JSP;
		}
		studentService.update(student);

		return STUDENT_REDIRECT_LIST;
	}

	@RequestMapping(value = { "/update" }, method = RequestMethod.GET)
	public String search(ModelMap model) {
		Student student = new Student();
		model.addAttribute("student", student);

		return SEARCH_AND_UPDATE_STUDENT_JSP;
	}

	@RequestMapping(value = { "/update" }, method = RequestMethod.POST)
	public String search(final Student student, final BindingResult result, final ModelMap model) {
		List<Student> students = studentService.findByStartsWithOr(student);
		model.addAttribute("student", student);
		model.addAttribute("students", students);	
		return SEARCH_AND_UPDATE_STUDENT_JSP;
	}

	@RequestMapping(value = { "/delete-{id}-student" }, method = RequestMethod.GET)
	public String delete(@PathVariable String id) {
		Student student = studentService.findById(new Integer(id));
		studentService.delete(student);
		return STUDENT_REDIRECT_LIST;
	}

	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String list(ModelMap model) {

		List<Student> students = studentService.findAll();
		Collections.sort(students, new StudentComparator());
		model.addAttribute("students", students);
		if (logger.isDebugEnabled()) {
			logger.debug("students: " + students);
		}
		return STUDENTS_JSP;
	}

	@RequestMapping(value = { "/ex" }, method = RequestMethod.GET)
	public String exception(ModelMap model) {
		Student nullStudent = new Student();
		nullStudent.getFirstName().toString(); // This throw NPE
		return STUDENTS_JSP;
	}

	@ExceptionHandler(Exception.class)
	public String handleException(Exception ex) {
		logger.error(ex.getMessage(), ex);
		return GLOBAL_ERROR_JSP;
	}

}
