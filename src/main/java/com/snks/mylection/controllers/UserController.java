package com.snks.mylection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.snks.mylection.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userServise;
	
	@RequestMapping("/users")
	public String users( Model model) {
		model.addAttribute("users", userServise.findAll());
		return "users";
		
	}
	
	
	@RequestMapping("/users/{id}")
	public String userDetail( Model model, @PathVariable int id) {
		model.addAttribute("user", userServise.findById(id));
		return "user";
		
	}

}
