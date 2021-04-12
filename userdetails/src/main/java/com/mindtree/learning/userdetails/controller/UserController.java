package com.mindtree.learning.userdetails.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.learning.userdetails.exception.ControllerException.ControllerException;
import com.mindtree.learning.userdetails.exception.ServiceException.ServiceException;
import com.mindtree.learning.userdetails.model.User;
import com.mindtree.learning.userdetails.service.UserService;
import com.mindtree.learning.userdetails.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {

	@Autowired
	private UserService us = new UserServiceImpl();


	@Value("${my.greeting}")
	private String msg;
	
	@RequestMapping("/property")
	public String getProperty() {
		return msg;
	}
	
	@RequestMapping("/get/{uId}")
	public ResponseEntity<?> getUser(@PathVariable int uId) throws ControllerException {
		try {
		return ResponseEntity.ok().body(us.getUserById(uId));
		}catch(ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}

	@RequestMapping("/getall")
	public ResponseEntity<?> getAllUser() throws ControllerException {
		try {
		return ResponseEntity.ok().body(us.getUsers());
		}catch(ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@RequestMapping("/add")
	public ResponseEntity<?> addUser(@RequestBody User user) throws ControllerException{
		try {
		return ResponseEntity.ok().body(us.addUser(user));
		}catch(ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
		}
	
	@RequestMapping("/delete/{uId}")
	public ResponseEntity<?> deleteUserById(@PathVariable int uId) throws ControllerException{
		try {
		return ResponseEntity.ok().body(us.deleteUser(uId));
		}catch(ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@RequestMapping("/update-name/{uId}/{newName}")
	public ResponseEntity<?> updateNameById(@PathVariable int uId, @PathVariable String newName) throws ControllerException{
		try {
		return ResponseEntity.ok().body(us.updateName(uId, newName));
		}catch(ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
}
