package com.snks.mylection.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.snks.mylection.model.SubjectClassification;
import com.snks.mylection.service.SubjectClassificationService;

@Controller
public class ClassificationController {
	@Autowired
	private SubjectClassificationService classificationService;
	
	
	  @ModelAttribute("classification")
	  public SubjectClassification constructClassification() {
	    return new SubjectClassification();
	  }
	  
	  @RequestMapping(value="/classifications", method=RequestMethod.POST)
	  public String doAddClassification( @Valid @ModelAttribute("classification") SubjectClassification classification, BindingResult bindingResult ) {
		  if (bindingResult.hasErrors()) {
			  return "classifications";
		  }
		classificationService.addSubjectClassification(classification);
	    return "redirect:/classifications";
	}
	  
	  
	@RequestMapping("/classifications")
    public String getClassifications( Model model) {
		model.addAttribute("classifications", classificationService.findAll());
	   return "classifications";
    }
		
	  @RequestMapping(value="/classifications/remove/{id}")
	  public String removeClassification(@PathVariable int id) {
		  classificationService.delete(id);
	    return "redirect:/classifications";
	    
	  }

	
}
