package com.snks.mylection.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snks.mylection.dao.UserDAO;
import com.snks.mylection.service.UserService;
import com.snks.mylection.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public void addDefaultUser() {
		userDAO.addDefaultUser();

	}
	
	@Transactional
	public List<User> findAll() {
		return userDAO.findAll();
		
	}
	
	@Transactional
	@Override
	public User findById(int id) {
		return userDAO.findById(id);
	}

}
