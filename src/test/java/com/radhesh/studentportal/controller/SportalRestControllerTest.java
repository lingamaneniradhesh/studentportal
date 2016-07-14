package com.radhesh.studentportal.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.radhesh.studentportal.model.User;
import com.radhesh.studentportal.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WebAppConfiguration.class)
@WebAppConfiguration
public class SportalRestControllerTest {

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	private MockMvc mockMvc;

	private HttpMessageConverter mappingJackson2HttpMessageConverter;

	private User user;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private UserService userService;

	@Autowired
	void setConverters(HttpMessageConverter<?>[] converters) {

		this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
				.filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().get();

		Assert.assertNotNull("the JSON message converter must not be null", this.mappingJackson2HttpMessageConverter);
	}

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();

		// this.userService.deleteAllInBatch();

		// this.user = userService.save(new User(userName, "password",
		// false));
	}

	@Test
	public void userNotFound() throws Exception {
		String userName = "NoUserName";
		mockMvc.perform(get("/retrieve/" + userName)).andExpect(status().isNotFound());
	}

	@Test
	public void retrieveUser() throws Exception {
		String userName = "TestUserName";
		mockMvc.perform(get("/retrieve/" + userName)).andExpect(status().isOk())
				.andExpect(content().contentType(contentType)).andExpect(jsonPath("$", hasSize(1)));
		// .andExpect(jsonPath("$[0].id",
		// is(this.bookmarkList.get(0).getId().intValue())))
		// .andExpect(jsonPath("$[0].uri", is("http://bookmark.com/1/" +
		// userName)))
		// .andExpect(jsonPath("$[0].description", is("A description")))
		// .andExpect(jsonPath("$[1].id",
		// is(this.bookmarkList.get(1).getId().intValue())))
		// .andExpect(jsonPath("$[1].uri", is("http://bookmark.com/2/" +
		// userName)))
		// .andExpect(jsonPath("$[1].description", is("A description")));
	}

	@Test
	public void createUser() throws Exception {
		String userName = "TestUserName";
		String password = "TestPassword";
		String userJson = json(new User(userName, password, false));
		// this.mockMvc.perform(post("/" + userName +
		// "/bookmarks").contentType(contentType).content(userJson)).andExpect(status().isCreated());

		this.mockMvc.perform(post("/save" + userName + "/" + password).contentType(contentType).content(userJson))
				.andExpect(status().isCreated());

	}

	protected String json(Object o) throws IOException {
		MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
		this.mappingJackson2HttpMessageConverter.write(o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
		return mockHttpOutputMessage.getBodyAsString();
	}
}