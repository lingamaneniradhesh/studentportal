package com.radhesh.studentportal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.radhesh.studentportal.model.Announcement;
import com.radhesh.studentportal.service.AnnouncementService;
import com.radhesh.studentportal.util.ViewNameConstants;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

	@Autowired
	private AnnouncementService announcementService;

	private static final int RANDOM_10 = 10;

	private static Logger logger = Logger.getLogger(DashboardController.class);

	@RequestMapping(value = {"/show" }, method = RequestMethod.GET)
	public String dashboard(ModelMap model) {
		Random random = new Random();
		List<Integer> dashboardImages = new ArrayList<>();
		dashboardImages.add(random.nextInt(RANDOM_10));
		dashboardImages.add(random.nextInt(RANDOM_10));
		dashboardImages.add(random.nextInt(RANDOM_10));
		dashboardImages.add(random.nextInt(RANDOM_10));
		model.addAttribute("dashboardImages", dashboardImages);
		List<Announcement> announcements = announcementService.findAll();
		model.addAttribute("announcements", announcements);
		return ViewNameConstants.DASHBOARD_JSP;
	}

}
