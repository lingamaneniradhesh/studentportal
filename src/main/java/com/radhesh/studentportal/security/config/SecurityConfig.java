package com.radhesh.studentportal.security.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/resources/**").permitAll()
				.antMatchers("/announcement/**", "/role/**", "/student/**", "/user/**").hasRole("ADMIN")
				.antMatchers("/dashboard/**", "/hobby/**", "/phone/**", "/vacation/**", "/timetracker/**")
				.access("hasRole('USER') or hasRole('ADMIN')").anyRequest().authenticated().and().formLogin()
				.loginPage(LOGIN_URI).permitAll().loginProcessingUrl(".." + LOGIN_URI);
	}
}
