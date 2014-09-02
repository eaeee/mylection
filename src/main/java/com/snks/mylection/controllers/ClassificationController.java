package com.snks.mylection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.snks.mylection.model.SubjectClassification;
import com.snks.mylection.service.SubjectClassificationService;

@Controller
public class ClassificationController {
	@Autowired
	private SubjectClassificationService classificationService;
	
	@RequestMapping("/classifications")
    public String getClassifications( Model model) {
		model.addAttribute("classifications", classificationService.findAll());
	   return "classifications";
    }
	
	@RequestMapping("/classifications1")
    public String asasdasddas() {
		String subjectClassificationName="Математика";
		SubjectClassification subjectClassification = new SubjectClassification();
		subjectClassification.setSubjectClassificationName(subjectClassificationName);
		classificationService.addSubjectClassification(subjectClassification);
	   return "redirect:/classifications";
    }

	
	  @RequestMapping(value="/classifications/remove/{id}")
	  public String removeClassification(@PathVariable int id) {
		  classificationService.delete(id);
	    return "redirect:/classifications";
	    
	  }
	
}
