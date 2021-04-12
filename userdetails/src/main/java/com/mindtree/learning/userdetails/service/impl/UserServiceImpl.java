package com.mindtree.learning.userdetails.service.impl;

import java.util.List;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mindtree.learning.userdetails.repository.UserDetailsRepo;
import com.mindtree.learning.userdetails.exception.ServiceException.ServiceException;
import com.mindtree.learning.userdetails.model.User;
import com.mindtree.learning.userdetails.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDetailsRepo ur;
	
	org.jboss.logging.Logger logger = LoggerFactory.logger(UserServiceImpl.class);

	
	@Override
	public User addUser(User user) throws ServiceException{
		try {
		return ur.save(user);
		}catch (DataAccessException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public String deleteUser(int uId)throws ServiceException{
		User user = null;
		try {
			user = ur.findById(uId).orElse(null);
		//user = ur.findById(uId).orElseThrow(()-> new ServiceException("No Such User Id Exist"));
		ur.delete(user);
		}catch (DataAccessException e) {
			throw new ServiceException(e.getMessage());
		}
		return "User : " + user.getName() + " Deleted Successfully";
	}

	@Override
	public User updateName(int uId, String newName) throws ServiceException {
		User user = null;
		try {
			user = ur.findById(uId).orElse(null);
			//user = ur.findById(uId).orElseThrow(()-> new ServiceException("No Such User Id Exist"));
		user.setName(newName);
		user = ur.save(user);
		}catch (DataAccessException e) {
			throw new ServiceException(e.getMessage());
		}
		return user;
	}

	@Override
	public User getUserById(int uId) throws ServiceException {
		User user = null;
		try {
			user = ur.findById(uId).orElse(null);
		//user = ur.findById(uId).orElseThrow(()-> new ServiceException("No Such User Id Exist"));
		}catch (DataAccessException e) {
			throw new ServiceException(e.getMessage());
		}
		return user;
	}
	
	@Override
	public List<User> getUsers() throws ServiceException{
		try {
		return ur.findAll();
		}catch (DataAccessException e) {
			throw new ServiceException(e.getMessage());
		}
	}

}
