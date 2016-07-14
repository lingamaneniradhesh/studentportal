package com.radhesh.studentportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/courses")
public class AcademicsController {
	
	/*private static Logger logger = Logger.getLogger(AcademicsController.class);

	
	@Autowired
	private AcademicsService academicsService;

	@RequestMapping(value = { "/", "", "/list" }, method = RequestMethod.GET)
	public String academics(ModelMap model) {
	List<Course> courses = academicsService.findAll();
		model.addAttribute("courses", courses);
		//System.out.println("the courses list is :"+courses);
		if (logger.isDebugEnabled()) {
			logger.debug(" curses: " + courses);
		}
		return ViewNameConstants.GRADUATEMAJORS_JSP;
	}*/
}
