package com.snks.mylection.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snks.mylection.dao.LectionDAO;
import com.snks.mylection.dao.SubjectClassificationDAO;
import com.snks.mylection.dao.SubjectDAO;
import com.snks.mylection.dao.UserDAO;
import com.snks.mylection.model.Role;

//@Service()
public class InitDbService {
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private LectionDAO lectionDAO;
	
	@Autowired
	private SubjectClassificationDAO subjectClassificationDAO;
	
	@Autowired
	private SubjectDAO subjectDAO;
	
	
	@PostConstruct
	public void  init(){
		Role roleAdmin = new Role();
		roleAdmin.setRoleName("ROLE_ADMIN");
	}
	
	

}
