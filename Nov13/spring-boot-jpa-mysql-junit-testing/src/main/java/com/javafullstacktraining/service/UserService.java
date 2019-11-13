package com.javafullstacktraining.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javafullstacktraining.dao.UserRepository;
import com.javafullstacktraining.entities.UserRecord;

import java.util.*;

@Service
public class UserService {
	@Autowired
	public UserRepository userRepository;
	public List<UserRecord> getAllUsers(){
		List<UserRecord> userRecords = new ArrayList<>();  
		userRepository.findAll().forEach(userRecords::add);
		return userRecords;
	}
	public Optional<UserRecord> getUser(Integer id){
		return userRepository.findById(id);
	}
	public UserRecord addUser(UserRecord userRecord) {
		return userRepository.save(userRecord);
	}
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}
	
	public UserRecord updateUser(Integer id,UserRecord userRecord) {
		Optional<UserRecord> userFromDb = userRepository.findById(id);
		if((userRecord.getName()!=null) && (userRecord.getEmail()!=null)) 
		  {
		userFromDb.get().setName(userRecord.getName());
		userFromDb.get().setEmail(userRecord.getEmail());		
		}
		else if(userRecord.getName()!=null)
		{
			userFromDb.get().setName(userRecord.getName());
		}
		else
		{
			userFromDb.get().setEmail(userRecord.getEmail());	
		}
			
		UserRecord upadedUser = userRepository.save(userFromDb.get());
		return upadedUser;
	}
	
}
