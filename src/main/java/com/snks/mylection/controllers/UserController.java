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

import com.snks.mylection.model.Course;
import com.snks.mylection.model.Lection;
import com.snks.mylection.model.User;
import com.snks.mylection.service.CourseService;
import com.snks.mylection.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userServise;
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/users")
	public String users( Model model) {
		model.addAttribute("users", userServise.findAll());
		return "users";
		
	}
	
	@ModelAttribute("user")
	public User constructUser() {
		return new User();
		
	}
	
	@ModelAttribute("lection")
	public Lection constructLection() {
		return new Lection();
		
	}
	
	
	@RequestMapping("/users/{id}")
	public String userDetail( Model model, @PathVariable int id) {
		model.addAttribute("user", userServise.findByIdWithLections(id));
		return "user";
		
	}
	
	@RequestMapping(value="/account")
	public String account(Model model, Principal principal) {
		String userName = principal.getName();
		model.addAttribute("user",userServise.findByNameWithLections(userName));
		model.addAttribute("courses", courseService.findAll());
		return "account";
		
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
	
	
	  @ModelAttribute("course")
	  public Course constructCourse() {
	    return new Course();
	  }
	  
	  
	  @RequestMapping(value="/account", method=RequestMethod.POST)
	  public String doAddCourse(@ModelAttribute("course") Course course, Principal principal) {
		  User user = userServise.findByName(principal.getName());
		  course.setCourseAuthor(user);
		  courseService.add(course);
	    return "redirect:/account";
	 }
	  
}
