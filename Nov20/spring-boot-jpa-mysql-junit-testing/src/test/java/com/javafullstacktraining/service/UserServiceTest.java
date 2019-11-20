package com.javafullstacktraining.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.javafullstacktraining.dao.UserRepository;
import com.javafullstacktraining.entities.UserRecord;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	@MockBean
	private UserRepository userRepository;
	
	@Test
	public void testAddUser() {
		
		UserRecord userRecord=new UserRecord();
		userRecord.setId(1);
		userRecord.setName("Kumar");
		userRecord.setEmail("kumar@gmail.com");
		
		Mockito.when(userRepository.save(userRecord)).thenReturn(userRecord);
		assertThat(userService.addUser(userRecord)).isEqualTo(userRecord);
		
	}
	
	@Test
	public void testGetUser() {
		UserRecord userRecord=new UserRecord();
		userRecord.setId(1);
		userRecord.setName("Kumar");
		userRecord.setEmail("kumar@gmail.com");
		
		Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(userRecord));
	    assertThat(userService.getUser(1)).isEqualTo(Optional.of(userRecord));
	}
	
	@Test
	public void testGetAllUsers() {
		
		UserRecord userRecord1=new UserRecord();
		userRecord1.setName("Kumar");
		userRecord1.setEmail("kumar@gmail.com");
		
		UserRecord userRecord2=new UserRecord();
		userRecord2.setName("Ramu");
		userRecord2.setEmail("ramu@gmail.com");
		
		List<UserRecord> usersList = new ArrayList<>();
		usersList.add(userRecord1);
		usersList.add(userRecord2);
		
		Mockito.when(userRepository.findAll()).thenReturn(usersList);
		assertThat(userService.getAllUsers()).isEqualTo(usersList);
		
	}
	
	@Test
	public void testUpdateUser() {
		UserRecord userRecord=new UserRecord();
		userRecord.setId(1);
		userRecord.setName("Kumar");
		userRecord.setEmail("kumar@gmail.com");
		
		Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(userRecord));
	    
		userRecord.setEmail("kumar123@gmail.com");
		Mockito.when(userRepository.save(userRecord)).thenReturn(userRecord);
		UserRecord userRecord1 = new UserRecord();
		userRecord1.setEmail("kumar@gmail.com");
		assertThat(userService.updateUser(1, userRecord1)).isEqualTo(userRecord);
	}
	
	@Test
	public void testDeleteUser() {
		UserRecord userRecord=new UserRecord();
		userRecord.setId(1);
		userRecord.setName("Kumar");
		userRecord.setEmail("kumar@gmail.com");
		
		Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(userRecord));
		Mockito.when(userRepository.existsById(userRecord.getId())).thenReturn(false);
		assertFalse(userRepository.existsById(userRecord.getId()));
		
	}
	
}
	
	
	
	


