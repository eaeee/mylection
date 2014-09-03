package com.snks.mylection.service.impl;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snks.mylection.dao.LectionDAO;
import com.snks.mylection.dao.RoleDAO;
import com.snks.mylection.dao.UserDAO;
import com.snks.mylection.service.UserService;
import com.snks.mylection.model.Lection;
import com.snks.mylection.model.Role;
import com.snks.mylection.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private RoleDAO roleDao;
	
	@Autowired
	private LectionDAO lectionDAO;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public List<User> findAll() {
		return userDAO.findAll();
		
	}
	

	@Override
	public User findById(int id) {
		return userDAO.findById(id);
	}
	

	@Override
	public void save(User user) {
		userDAO.save(user);
	}
	
	@Override
	public void saveUser(User user) {
		user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
		
		List<Role> userRoles = new ArrayList<Role>();
		userRoles.add(roleDao.findByName("ROLE_USER"));
		
		user.setRoles(userRoles);
		
		userDAO.save(user);
	}
	
	@Override
	public void saveAdmin(User user) {
		user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
		
		List<Role> userRoles = new ArrayList<Role>();
		userRoles.add(roleDao.findByName("ROLE_ADMIN"));
		
		user.setRoles(userRoles);
		
		userDAO.save(user);
	}

	@Override
	public User findByName(String userName) {
		return userDAO.findUserByName(userName);
	}

	@Override
	public void delete(int id) {
		userDAO.delete(id);
		
	}

	@Override
	public User findByNameWithLections(String userName) {
		User user = findByName(userName);
		List<Lection> lections = lectionDAO.findByUser(user);
		user.setLections(lections);
		return user;
	}


	@Override
	public User findByIdWithLections(int id) {
		User user = findById(id);
		List<Lection> lections = lectionDAO.findByUser(user);
		user.setLections(lections);
		return user;
	}

}
