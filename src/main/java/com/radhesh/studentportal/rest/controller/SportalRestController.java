package com.radhesh.studentportal.rest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.radhesh.studentportal.model.User;
import com.radhesh.studentportal.service.UserService;

@RestController
public class SportalRestController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = { "/srest" }, method = RequestMethod.GET)
	public User user(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password) {
		return new User(userName, password, false);
	}

	@RequestMapping(value = { "/match" }, method = RequestMethod.GET)
	public ResponseEntity<?> match(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password) {
		if (userName.equalsIgnoreCase("Bhaskar")) {
			User user = new User(userName, password, false);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			UserNotFoundException ex = new UserNotFoundException(userName);
			return new ResponseEntity<>(ex, HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = { "/retrieve/{userName}" }, method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public User retrieve(@PathVariable Integer userId) {
		return userService.findById(userId);
	}

	@RequestMapping(value = { "/save/{userName}/{password}" }, method = RequestMethod.POST)
	public void save(@PathVariable String userName, @PathVariable String password) {
		User user = new User(userName, password, false);
		userService.save(user);
	}

	@RequestMapping(value = { "/restupdate" }, method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<User> update(@RequestBody User user) {
//		userService.save(user);
		return new ResponseEntity(userService.findById(user.getId()), HttpStatus.OK);
	}

	@RequestMapping(value = { "/restupdate/all" }, method = RequestMethod.POST)
	public ResponseEntity<User> updateAll(@RequestBody List<User> users) {
//		userService.save(user);
		return new ResponseEntity(users, HttpStatus.OK);
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	class UserNotFoundException extends RuntimeException {

		UserNotFoundException(String userName) {
			super("User name not found: " + userName);
		}
	}

}
