package com.snks.mylection.service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.snks.mylection.dao.RoleDAO;
import com.snks.mylection.dao.UserDAO;
import com.snks.mylection.model.Role;
import com.snks.mylection.model.User;

//@Service
//@Transactional
public class InitDbService {
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
/*	@Autowired
	private LectionDAO lectionDao;
	
	@Autowired
	private SubjectClassificationDAO subjectClassificationDao;
	
	@Autowired
	private SubjectDAO subjectDao;*/
	
	@Autowired
	private RoleDAO roleDao;
	
	
	
	@PostConstruct
	public void  init(){
		Role roleAdmin = new Role();
		Role roleUser = new Role();
		roleAdmin.setRoleName("ROLE_ADMIN");
		roleUser.setRoleName("ROLE_USER");
		
		String adminPassword="admin";
		adminPassword = passwordEncoder.encode(adminPassword);
		String userPassword="user";
		userPassword = passwordEncoder.encode(userPassword);
		
		
		User userAdmin = new User();
		User userUser = new User();
		userAdmin.setUserPassword(adminPassword);
		userUser.setUserPassword(userPassword);
		userAdmin.setUserName("admin");
		userUser.setUserName("user");
		List<Role> adminRoles = new ArrayList<Role>();
		adminRoles.add(roleAdmin);
		userAdmin.setRoles(adminRoles);
		List<Role> userRoles = new ArrayList<Role>();
		userRoles.add(roleUser);
		userUser.setRoles(userRoles);
		
		roleDao.save(roleUser);
		roleDao.save(roleAdmin);
		
		userDao.save(userUser);
		userDao.save(userAdmin);
		
	}
	
	

}
