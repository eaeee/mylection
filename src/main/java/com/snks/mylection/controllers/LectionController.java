package com.snks.mylection.controllers;


import java.io.IOException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;






import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.snks.mylection.model.Lection;
import com.snks.mylection.model.json.LectionJSON;
import com.snks.mylection.service.LectionService;
import com.snks.mylection.service.UserService;

@Controller
public class LectionController {
	@Autowired
	private UserService userServise;
	@Autowired
	private LectionService lectionService;
	@Autowired 
	private JsonFactory jsonFactory;
	
	@RequestMapping("/addlection")
    public String login(Model model,Principal principal) {
	   return "lection_blank";
    }
	
	
	@RequestMapping(value="/addlection/save",method=RequestMethod.POST , consumes="application/json")
    public void addLection(@RequestBody String lectionJSON) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper objectMapper =  new ObjectMapper();
		LectionJSON lect = objectMapper.readValue(lectionJSON, LectionJSON.class);
		lectionService.saveFromJSON(lect);
    }
	
	
	
/*	
	@RequestMapping(value="/addlection", method=RequestMethod.POST)
	public String doAddLection(@ModelAttribute("lection") Lection lection,Principal principal) {
		String name = principal.getName();
		lectionService.save(lection, name);
		return "redirect:/addlection";
		
	}
	*/
}
