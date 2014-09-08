package com.snks.mylection.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SearchController {
	

	   @RequestMapping("/search_lections")
	    public String showSearchLecrtions() {
	        return "search_lections";

	    }
	   
	   @RequestMapping("/search_courses")
	    public String showSearchCourses() {
	        return "search_courses";

	    }
}
