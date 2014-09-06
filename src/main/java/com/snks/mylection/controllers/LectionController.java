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
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.snks.mylection.model.Lection;
import com.snks.mylection.model.Subject;
import com.snks.mylection.model.SubjectClassification;
import com.snks.mylection.model.json.LectionJSON;
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
	public String removeLection(@PathVariable int id) {
		Lection lection = lectionService.findById(id);
		lectionService.delete(lection);
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
	   lectionService.save(lection);
	   model.addAttribute("lection",lection);
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

	
}
