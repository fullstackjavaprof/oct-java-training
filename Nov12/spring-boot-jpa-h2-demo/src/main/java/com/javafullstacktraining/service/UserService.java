package com.javafullstacktraining.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javafullstacktraining.dao.UserRecord;
import com.javafullstacktraining.dao.UserRepository;
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
	public Optional<UserRecord> getUser(String id){
		return userRepository.findById(id);
	}
	public void addUser(UserRecord userRecord) {
		userRepository.save(userRecord);
	}
	public void deleteUser(String id) {
		userRepository.deleteById(id);
	}
}
