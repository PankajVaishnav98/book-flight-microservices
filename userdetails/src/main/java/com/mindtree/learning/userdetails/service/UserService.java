package com.mindtree.learning.userdetails.service;

import java.util.List;

import com.mindtree.learning.userdetails.exception.ServiceException.ServiceException;
import com.mindtree.learning.userdetails.model.User;

public interface UserService {

	public User addUser(User user)throws ServiceException;
	public String deleteUser(int uId) throws ServiceException;
	public User updateName(int uId, String newName) throws ServiceException;
	public User getUserById(int uId) throws ServiceException;
	public List<User> getUsers()throws ServiceException;
}
