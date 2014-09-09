package com.snks.mylection.controllers;


import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.snks.mylection.model.Course;
import com.snks.mylection.model.Lection;
import com.snks.mylection.model.Subject;
import com.snks.mylection.model.SubjectClassification;
import com.snks.mylection.model.User;
import com.snks.mylection.model.json.LectionJSON;
import com.snks.mylection.service.CourseService;
import com.snks.mylection.service.LectionService;
import com.snks.mylection.service.SubjectClassificationService;
import com.snks.mylection.service.SubjectService;
import com.snks.mylection.service.UserService;

@Controller
public class LectionController {
	@Autowired
	private UserService userServise;
	@Autowired
	private LectionService lectionService;
	@Autowired 
	private JsonFactory jsonFactory;
	@Autowired
	private SubjectService subjectService; 
	@Autowired
	private SubjectClassificationService subjectClassificationService;
	@Autowired
	private CourseService  courseService;
	@Autowired
	private UserService userService;
	@RequestMapping("/addlection")
    public String add(Model model,Principal principal) {
		List<Subject> subjects= subjectService.findAll();
		List<SubjectClassification> classifications = subjectClassificationService.findAll();
		model.addAttribute("subjects",subjects);
		model.addAttribute("classifications",classifications);
		return "lection_blank";
    }
	
	@RequestMapping(value="/lections/save",method=RequestMethod.POST , consumes="application/json")
	@ResponseBody
	public int addLection(@RequestBody String lectionJSON) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper objectMapper =  new ObjectMapper();
		LectionJSON lect = objectMapper.readValue(lectionJSON, LectionJSON.class);
		int lectId = lectionService.saveFromJSON(lect);
		System.out.println(lectId);
		return lectId;
    }
	
	@RequestMapping(value="/lections/remove/{id}")
	public String removeLection(@PathVariable int id, @RequestParam String target) {
		Lection lection = lectionService.findById(id);
		lectionService.delete(lection);
		System.out.println(target);
		if (target.equals("user")) {
			return "redirect:/account";
		} 
		if (target.equals("lections")) {
			return "redirect:/all_lections";
		} 
		return "redirect:/";
    }
	
	@RequestMapping(value="/all_lections")
	public String getAllLections(Model model) {
		List<Lection> lections = lectionService.findAll();
		model.addAttribute("lections",lections);
		return "all_lections";
    }
	
	@RequestMapping(value="/lections/{id}")
	public String getLection(@PathVariable int id,Model model,Principal principal) {
	   Lection lection = lectionService.findById(id);
	   lection.getLectionDate().setAccessedDate(new Date());
	   lectionService.update(lection);
	   model.addAttribute("lection",lection);
	   model.addAttribute("courses", courseService.findByUserName(principal.getName()));
	  return "lection_read";
    }
	
	@RequestMapping(value="/lections/getSubjects/{classificationName}")
	public @ResponseBody String getSubjects(@PathVariable String classificationName,Model model,Principal principal) throws JsonProcessingException {
		List<String> subjects = subjectService.getSubjectsNamesByClass(classificationName);
		ObjectMapper objectMapper =  new ObjectMapper();
		String test = objectMapper.writeValueAsString(subjects);
		System.out.println(test);
		return test;
    }
	
	@RequestMapping("/lections/edit/{id}")
    public String editLection(@PathVariable int id,Model model,Principal principal) {
		Lection lection = lectionService.findById(id);
		if (principal.getName().equals(lection.getAuthor().getUserName())) {
			model.addAttribute("lection",lection);
			return "lection_edit";
		}
		return null;
    }
	
	@RequestMapping(value= "/lections/update/{id}",method=RequestMethod.POST , consumes="application/json")
    public  @ResponseBody int updateLection(@PathVariable int id,@RequestBody String lectionJSON) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper =  new ObjectMapper();
		LectionJSON lect = objectMapper.readValue(lectionJSON, LectionJSON.class);
		return lectionService.updateFromJSON(lect,id);
    }

	
	@RequestMapping("/lections/saveincourse")
    public @ResponseBody int saveInCourse(Principal principal,@RequestParam int lectionId, @RequestParam int courseId) {
		String userName = principal.getName();
		User user = userService.findByName(userName);
		Lection lection = lectionService.findByIdWithCourses(lectionId);
		Course course = courseService.findByIdWithLections(courseId);
		List<Lection> lections = course.getLections();
		lections.add(lection);
		List<Course> courses = lection.getCourses();
		courses.add(course);
		if (course.getCourseAuthor()==user) {
			lectionService.update(lection);
			courseService.update(course);
			return courseId;
		}
		return courseId;
    }
	
}
