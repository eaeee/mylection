package com.snks.mylection.controllers;

import java.security.Principal;
import java.util.List;

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
	  public String showCourse( @PathVariable int id, Model model,Principal principal){
		  boolean subscribed=false;
		 String userName  = principal.getName();
		 User user = userservice.findByNameWithSubs(userName);
		 Course course =  courseService.findByIdWithLections(id);
		 List<Course> courses = user.getSubCourses();
		 for (Course c : courses) {
			 if(c.getCourseName().equals(course.getCourseName())) {
				 subscribed=true;
			 }
		 }
		 model.addAttribute("subscribed",subscribed);
		 model.addAttribute("course",course);
		 model.addAttribute("lections",course.getLections());
	    return "course";
	}
	  
	  
	  @RequestMapping(value="/courses/follow",method = RequestMethod.POST)
	  @ResponseBody
	  public int followCourse( @RequestParam int courseId,Principal principal){
		 String userName  = principal.getName();
		 Course course =  courseService.findByIdWithFollowers(courseId);
		 User user = userservice.findByNameWithSubs(userName);
		 course.getFollowers().add(user);
		 user.getSubCourses().add(course);
		 courseService.update(course);
		 userservice.update(user);
	    return courseId;
	}
	  
	  @RequestMapping(value="/courses/unfollow",method = RequestMethod.POST)
	  @ResponseBody
	  public int unfollowCourse( @RequestParam int courseId,Principal principal){
		 String userName  = principal.getName();
		 Course course =  courseService.findByIdWithFollowers(courseId);
		 User user = userservice.findByNameWithSubs(userName);
		 List<Course> courses = user.getSubCourses();
		 List<User> followers = course.getFollowers();
		 user.getSubCourses().clear();
		 course.getFollowers().clear();
		 for (User u: followers) {
			if (u.getUserId()==user.getUserId()) {
				followers.remove(u);
			}
		 }
		 for (Course c: courses) {
			 if(c.getCourseId()==course.getCourseId()) {
				 courses.remove(c);
			 }
		 }
		 user.getSubCourses().addAll(courses);
		 course.getFollowers().addAll(followers);
		 courseService.update(course);
		 userservice.update(user);
	    return courseId;
	}

}
