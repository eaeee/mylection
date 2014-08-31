package com.snks.mylection.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.snks.mylection.model.User;
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
	
	@ModelAttribute("user")
	public User construct() {
		return new User();
		
	}
	
	
	@RequestMapping("/users/{id}")
	public String userDetail( Model model, @PathVariable int id) {
		model.addAttribute("user", userServise.findById(id));
		return "user";
		
	}
	
	
	@RequestMapping("/register")
	public String showRegister() {
		return "register";
		
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult bindingResult ) {
		if (bindingResult.hasErrors()) {
			return "register";
		}
		userServise.saveUser(user);
		return "redirect:/register?success=true";
		
	}
	
	
	@RequestMapping(value="/account")
	public String account(Model model, Principal principal) {
		String userName = principal.getName();
		model.addAttribute("user",userServise.findByName(userName));
		return "account";
		
	}
	
	@RequestMapping(value="/users/remove/{id}")
	public String removeUser(@PathVariable int id) {
		userServise.delete(id);
		return "redirect:/users";
		
	}
	
	
	@RequestMapping("/available")
	@ResponseBody
	public String available(@RequestParam String userName) {
		Boolean available = (userServise.findByName(userName)==null);
		return available.toString();
		
	}

}
