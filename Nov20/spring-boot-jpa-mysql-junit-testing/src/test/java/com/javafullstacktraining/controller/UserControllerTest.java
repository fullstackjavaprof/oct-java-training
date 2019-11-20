package com.javafullstacktraining.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javafullstacktraining.entities.UserRecord;
import com.javafullstacktraining.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=UserController.class,secure = false)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	@Test
	public void testAddUser() throws Exception {
		
		UserRecord userRecord=new UserRecord();
		userRecord.setId(1);
		userRecord.setName("Kumar");
		userRecord.setEmail("kumar@gmail.com");
		
		String inputInJson = this.mapToJson(userRecord);
		
		String URI = "/users/addUser";
		
		Mockito.when(userService.addUser(Mockito.any(UserRecord.class))).thenReturn(userRecord);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);
				                        
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
	}
	
	@Test
	public void testGetUser() throws Exception {
		UserRecord userRecord=new UserRecord();
		userRecord.setId(1);
		userRecord.setName("Kumar");
		userRecord.setEmail("kumar@gmail.com");
		
		Mockito.when(userService.getUser((Mockito.anyInt()))).thenReturn(Optional.of(userRecord));
		
		String URI = "/users/getUser/1";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(userRecord);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	
	@Test
	public void testGetAllUsers() throws Exception{
		
		UserRecord userRecord1=new UserRecord();
		userRecord1.setName("Kumar");
		userRecord1.setEmail("kumar@gmail.com");
		
		UserRecord userRecord2=new UserRecord();
		userRecord2.setName("Ramu");
		userRecord2.setEmail("ramu@gmail.com");
		
		List<UserRecord> usersList = new ArrayList<>();
		usersList.add(userRecord1);
		usersList.add(userRecord2);
		
		Mockito.when(userService.getAllUsers()).thenReturn(usersList);
		
		String URI = "/users/getAllUsers";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(usersList);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
		
	}
	
	/**
	 * Maps an Object into a JSON String. Uses a Jackson ObjectMapper.
	 */
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}
