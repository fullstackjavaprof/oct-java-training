package com.javafullstacktraining.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javafullstacktraining.dao.UserRecord;
import com.javafullstacktraining.service.UserService;

import java.util.*;

@RestController
public class UserController {
     @Autowired
     public UserService userService;
     @RequestMapping("/getAllUsers")
     public List<UserRecord> getAllUsers() {
    	 return userService.getAllUsers();
     }
     @RequestMapping(value="/addUser", method=RequestMethod.POST)
     public String addUser(@RequestBody UserRecord userRecord) {
    	 userService.addUser(userRecord);
    	 return "User added successfully.";
     }
     @RequestMapping(value="/getUser/{id}", method=RequestMethod.GET)
    public Optional<UserRecord> getUser(@PathVariable String id){
    	 return userService.getUser(id);
     }
     @RequestMapping(value="/deleteUser/{id}", method=RequestMethod.DELETE)
     public void deleteUser(@PathVariable String id){
     	 userService.deleteUser(id);
      }
     @RequestMapping(value="/updateUser", method=RequestMethod.PUT)
     public String updateUser(@RequestBody UserRecord userRecord) { 
    	 Optional<UserRecord> existingUserRecord=userService.getUser(userRecord.getId());
    	 if(existingUserRecord.isPresent()) {
    		 userService.addUser(userRecord);
    		 return "User details updated successfully.";
    	 }else {
    		 return "User details are not available.";
    	 }
     }
}
