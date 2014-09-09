package com.snks.mylection.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.snks.mylection.model.Course;
import com.snks.mylection.model.User;
import com.snks.mylection.service.CourseService;
import com.snks.mylection.service.UserService;

@Controller
public class CourseController {
	@Autowired
	public CourseService courseService;
	
	@Autowired
	private UserService userservice;
	
	  @RequestMapping(value="/courses/{id}")
	  public String showCourse( @PathVariable int id, Model model){
		 Course course =  courseService.findByIdWithLections(id);
		 model.addAttribute("course",course);
		 model.addAttribute("lections",course.getLections());
	    return "course";
	}
	  
	  
	  @RequestMapping(value="/courses/follow",method = RequestMethod.POST)
	  @ResponseBody
	  public int followCourse( @RequestParam int courseId,Principal principal){
		 Course course =  courseService.findById(courseId);
		 String userName  = principal.getName();
		 User user = userservice.findByName(userName);
		 course.getFollowers().add(user);
	    return courseId;
	}

}
