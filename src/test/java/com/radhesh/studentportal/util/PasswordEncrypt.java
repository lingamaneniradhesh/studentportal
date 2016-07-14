package com.radhesh.studentportal.util;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncrypt {

	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@Test
	public void encodePassword() {
		String password = "rdravid123";
		String encodedPassword = bCryptPasswordEncoder.encode(password);
		System.out.println(encodedPassword);
		boolean isMatched = bCryptPasswordEncoder.matches(password, encodedPassword);
		assertTrue(isMatched);
		assertNotSame(password, encodedPassword);
	}
}
