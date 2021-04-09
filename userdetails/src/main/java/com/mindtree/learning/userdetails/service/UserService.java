package com.mindtree.learning.userdetails.service;

import java.util.List;

import com.mindtree.learning.userdetails.model.User;

public interface UserService {

	public User addUser(User user);
	public String deleteUser(int uId) throws Exception;
	public User updateName(int uId, String newName) throws Exception;
	public User getUserById(int uId) throws Exception;
	public List<User> getUsers();
}
