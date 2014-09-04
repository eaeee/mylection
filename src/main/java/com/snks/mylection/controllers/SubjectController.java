package com.snks.mylection.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.snks.mylection.model.Subject;
import com.snks.mylection.model.SubjectClassification;
import com.snks.mylection.service.SubjectClassificationService;
import com.snks.mylection.service.SubjectService;




@Controller
public class SubjectController {
	
	@Autowired
	SubjectService subjectService;
	@Autowired
	SubjectClassificationService subjectClassificationService;
	
	@ModelAttribute("subject")
	public Subject constructSubject() {
		return new Subject();
	}
	
	@ModelAttribute("classification")
	public SubjectClassification getClassification() {
		return new SubjectClassification();
	}

	@RequestMapping(value="/subjects", method=RequestMethod.POST)
	public String doAddSubject(/*@Valid*/ @ModelAttribute("subject") Subject subject,@ModelAttribute("classification") SubjectClassification classification,BindingResult bindingResult ) {
		if (bindingResult.hasErrors()) {
			return "subjects";
		}
		subjectService.saveWithClass(subject,classification.getSubjectClassificationName());
	    return "redirect:/subjects";
	}
	
	@RequestMapping("/subjects")
    public String getSubjects( Model model) {
		model.addAttribute("subjects", subjectService.findAll());
		model.addAttribute("classifications",subjectClassificationService.findAllNames());
	   return "subjects";
    }
	
	  @RequestMapping(value="/subjects/remove/{id}")
	  public String removeSubject(@PathVariable int id) {
		  subjectService.delete(id);
	    return "redirect:/subjects";
	    
	  }

}
