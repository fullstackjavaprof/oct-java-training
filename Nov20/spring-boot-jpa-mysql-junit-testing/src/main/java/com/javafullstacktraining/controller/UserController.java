package com.javafullstacktraining.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javafullstacktraining.entities.UserRecord;
import com.javafullstacktraining.service.UserService;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {
     @Autowired
     public UserService userService;
     @GetMapping("/getAllUsers")
     public List<UserRecord> getAllUsers() {
    	 return userService.getAllUsers();
     }
     @PostMapping(value="/addUser")
     public UserRecord addUser(@RequestBody UserRecord userRecord) {
    	 return userService.addUser(userRecord);
     }
     @GetMapping(value="/getUser/{id}")
    public Optional<UserRecord> getUser(@PathVariable Integer id){
    	 return userService.getUser(id);
     }
     @DeleteMapping(value="/deleteUser/{id}")
     public String deleteUser(@PathVariable Integer id){
     	 userService.deleteUser(id);
     	 return "User is deleted successfully.";
      }
     @PutMapping(value="/updateUser/{id}")
     public UserRecord updateUser(@PathVariable Integer id,@RequestBody UserRecord userRecord) { 
    	 return userService.updateUser(id,userRecord);
     }
}
