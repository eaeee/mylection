package com.snks.mylection.service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import com.snks.mylection.config.InitDbCondition;
import com.snks.mylection.model.Role;
import com.snks.mylection.model.User;

@Service
@Transactional
@Conditional(InitDbCondition.class)
public class InitDbService {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService; 
	
	

	@PostConstruct
	public void  init(){
		Role roleAdmin = new Role();
		Role roleUser = new Role();
		roleAdmin.setRoleName("ROLE_ADMIN");
		roleUser.setRoleName("ROLE_USER");
		roleService.save(roleAdmin);
		roleService.save(roleUser);
		
		
		String adminPassword="admin";
		String userPassword="user";
		
		
		User userAdmin = new User();
		userAdmin.setUserName("admin");
		List<Role> adminRoles = new ArrayList<Role>();
		adminRoles.add(roleAdmin);
		userAdmin.setRoles(adminRoles);
		userAdmin.setUserPassword(adminPassword);
		
		User userUser = new User();
		userUser.setUserName("user");
		List<Role> userRoles = new ArrayList<Role>();
		userRoles.add(roleUser);
		userUser.setRoles(userRoles);
		userUser.setUserPassword(userPassword);
			
		userService.saveAdmin(userAdmin);
		userService.saveUser(userUser);
	}
	
	

}
