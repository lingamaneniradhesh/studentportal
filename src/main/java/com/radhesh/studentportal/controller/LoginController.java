package com.radhesh.studentportal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.radhesh.studentportal.exception.InvalidUserCredentialsException;
import com.radhesh.studentportal.exception.NonNullableFieldException;
import com.radhesh.studentportal.model.User;
import com.radhesh.studentportal.service.UserService;
import com.radhesh.studentportal.util.ViewNameConstants;

@Controller
@RequestMapping("/login")
public class LoginController implements ViewNameConstants {

	public static final String LOGIN_URI = "/login/login";

	private static Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login(ModelMap model) {
		model.addAttribute("user", new User());
		return LOGIN_JSP;
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String signin(@Valid User user, BindingResult result, ModelMap model, HttpServletRequest request) {

		if (result.hasErrors()) {
			return LOGIN_JSP;
		}

		try {
			User signedInUser = userService.signIn(user.getUserName(), user.getPassword());
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority(signedInUser.getRole().getRoleName()));
			Authentication authentication = new UsernamePasswordAuthenticationToken(signedInUser.getUserName(),
					signedInUser.getPassword(), authorities);
			SecurityContext securityContext = SecurityContextHolder.getContext();
			securityContext.setAuthentication(authentication);
			HttpSession session = request.getSession(true);
			session.setAttribute("signedInUser", signedInUser);
			session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, securityContext);

		} catch (NonNullableFieldException | InvalidUserCredentialsException e) {
			logger.error(e.getMessage(), e);
			model.addAttribute("fail", e.getMessage());
			return LOGIN_JSP;
		}
		return "redirect:/dashboard/show";
	}

	@RequestMapping(value = { "/clear" }, method = RequestMethod.POST)
	public String reset(@Valid User user, BindingResult result, ModelMap model) {
		user.setUserName("");
		user.setPassword("");
		model.addAttribute("success", "Reset successful");
		return LOGIN_JSP;
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String logout(ModelMap model, HttpServletRequest request) throws ServletException {
		request.logout();
		return "redirect:" + LOGIN_URI;
	}
}
