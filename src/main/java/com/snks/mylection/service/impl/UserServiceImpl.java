package com.snks.mylection.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snks.mylection.dao.UserDAO;
import com.snks.mylection.service.UserService;
import com.snks.mylection.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public void addDefaultUser() {
		userDAO.addDefaultUser();

	}
	
	public List<User> findAll() {
		return userDAO.findAll();
		
	}
	

	@Override
	public User findById(int id) {
		return userDAO.findById(id);
	}
	

	@Override
	public void save(User user) {
		user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
		userDAO.save(user);
		
	}

}
