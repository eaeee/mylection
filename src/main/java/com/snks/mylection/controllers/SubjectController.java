package com.snks.mylection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.snks.mylection.model.Subject;
import com.snks.mylection.service.SubjectService;




@Controller
public class SubjectController {
	
	@Autowired
	SubjectService subjectService;
	
	@RequestMapping("/subjects")
    public String getSubjects( Model model) {
		model.addAttribute("subjects", subjectService.findAll());
	   return "subjects";
    }
	
	@RequestMapping("/subjects1")
    public String asdas() {
		String subjectName="Математический анализ";
		Subject subject =  new Subject();
		subject.setSubjectName(subjectName);
		subjectService.addSubject(subject);
	   return "redirect:/subjects";
    }
	
	  @RequestMapping(value="/subjects/remove/{id}")
	  public String removeSubject(@PathVariable int id) {
		  subjectService.delete(id);
	    return "redirect:/subjects";
	    
	  }

}
