package com.javafullstacktraining.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.javafullstacktraining.entities.UserRecord;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private TestEntityManager testEntityManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void testSaveUser() {
		UserRecord userRecord=getUser();
		UserRecord savedInDb = testEntityManager.persist(userRecord);
		Optional<UserRecord> getFromDb = userRepository.findById(savedInDb.getId());
		assertThat(getFromDb.get()).isEqualTo(savedInDb);
	}
	
	@Test
	public void testGetUserById() {
		UserRecord userRecord=new UserRecord();
		userRecord.setName("Vasu");
		userRecord.setEmail("vasu@gmail.com");
		UserRecord savedInDb = testEntityManager.persist(userRecord);
		Optional<UserRecord> getFromDb = userRepository.findById(savedInDb.getId());
		assertThat(getFromDb.get()).isEqualTo(savedInDb);
	}
	
	@Test
	public void testGetAllUsers() {
		UserRecord userRecord1=new UserRecord();
		userRecord1.setName("Kumar");
		userRecord1.setEmail("kumar@gmail.com");
		
		UserRecord userRecord2=new UserRecord();
		userRecord2.setName("Ramu");
		userRecord2.setEmail("ramu@gmail.com");
		
		//Save both users in DB
		testEntityManager.persist(userRecord1);
		testEntityManager.persist(userRecord2);
				
				Iterable<UserRecord> allUsersFromDb = userRepository.findAll();
				List<UserRecord> userList = new ArrayList<>();
				
				for (UserRecord user : allUsersFromDb) {
					userList.add(user);
				}
				assertThat(userList.size()).isEqualTo(2);
	}
	
	@Test
	public void testUpdateUser(){
		UserRecord userRecord1=new UserRecord();
		userRecord1.setName("Hari");
		userRecord1.setEmail("hari@gmail.com");
		
		//save User info in DB
		testEntityManager.persist(userRecord1);
		
		Optional<UserRecord> getFromDb = userRepository.findById(userRecord1.getId());
		//update Email Address
		getFromDb.get().setEmail("hari123@gmail.com");
		testEntityManager.persist(getFromDb.get());
		
		assertThat(getFromDb.get().getEmail()).isEqualTo("hari123@gmail.com");
	}
	
	@Test
	public void testDeleteUserById() {
		UserRecord userRecord1=new UserRecord();
		userRecord1.setName("Kumar");
		userRecord1.setEmail("kumar@gmail.com");
		
		UserRecord userRecord2=new UserRecord();
		userRecord2.setName("Ramu");
		userRecord2.setEmail("ramu@gmail.com");
		
		//Save both users in DB
		UserRecord savedUser = testEntityManager.persist(userRecord1);
		testEntityManager.persist(userRecord2);
		
		//delete one user from DB
		testEntityManager.remove(savedUser);
		
		Iterable<UserRecord> allUsersFromDb = userRepository.findAll();
		List<UserRecord> userList = new ArrayList<>();
		
		for (UserRecord user : allUsersFromDb) {
			userList.add(user);
		}
		assertThat(userList.size()).isEqualTo(1);
		
	}
		
	private UserRecord getUser() {
		UserRecord userRecord=new UserRecord();
		userRecord.setName("Ramu");
		userRecord.setEmail("ramu@gmail.com");
		return userRecord;
	}
	

}
