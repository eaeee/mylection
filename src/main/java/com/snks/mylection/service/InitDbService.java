package com.snks.mylection.service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snks.mylection.model.Role;
import com.snks.mylection.model.User;

@Service
@Transactional
public class InitDbService {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService; 
	
	

	@PostConstruct
	public void  init(){
		if(userService.findById(1)==null){
			
			Role roleAdmin = new Role();
			Role roleUser = new Role();
			roleAdmin.setRoleName("ROLE_ADMIN");
			roleUser.setRoleName("ROLE_USER");
			roleService.save(roleAdmin);
			roleService.save(roleUser);
			
			
			String adminPassword="adminadmin";
			String userPassword="useruser";
			
			
			User userAdmin = new User();
			userAdmin.setUserName("adminadmin");
			List<Role> adminRoles = new ArrayList<Role>();
			adminRoles.add(roleAdmin);
			userAdmin.setRoles(adminRoles);
			userAdmin.setUserPassword(adminPassword);
			
			User userUser = new User();
			userUser.setUserName("useruser");
			List<Role> userRoles = new ArrayList<Role>();
			userRoles.add(roleUser);
			userUser.setRoles(userRoles);
			userUser.setUserPassword(userPassword);
				
			userService.saveAdmin(userAdmin);
			userService.saveUser(userUser);
		}
	}
	
	

}
