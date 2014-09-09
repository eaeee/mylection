package com.snks.mylection.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.snks.mylection.model.Course;
import com.snks.mylection.model.Lection;
import com.snks.mylection.model.Subject;
import com.snks.mylection.service.CourseService;
import com.snks.mylection.service.LectionService;
import com.snks.mylection.service.SubjectService;


@Controller
public class SearchController {
	
	@Autowired
	public SubjectService subjectService;
	
	@Autowired
	public LectionService  lectionService;
	
	@Autowired
	public CourseService courseService;
	

	   @RequestMapping("/search_lections")
	    public String showSearchLecrtions(Model model) {
		   List<Subject> subjects = subjectService.findAll();
		   model.addAttribute("subjects", subjects);
	        return "search_lections";

	    }
	   
	   @RequestMapping("/search_courses")
	    public String showSearchCourses() {
	        return "search_courses";

	    }  

	   @RequestMapping(value="/searchCourseForm", method = RequestMethod.POST)
	    public String SearchCourses( Model model, @RequestParam(value = "word") String word) {
		   List<Course> courses = courseService.search(word);
		   model.addAttribute("courses",courses);
	        return "search_courses";
	    }
	   
	   @RequestMapping(value="/searchLectionForm", method = RequestMethod.POST)
	    public String SearchLections( Model model, @RequestParam(value = "word") String word,@RequestParam(value = "wordInBody") String wordInBody,
	    		@RequestParam(value = "subejct") String subjectName	) {
		   List<Subject> subjects = subjectService.findAll();
		   model.addAttribute("subjects", subjects);
		   Subject subject;
		   if (subjectName=="none") {
			   subject = null;
		   } else {
			   subject = subjectService.findByName(subjectName);
		   }
		   List<Lection> lections = lectionService.search(word,wordInBody,subject);
		   model.addAttribute("lections",lections);
	        return "search_lections";
	    }
	   
}
