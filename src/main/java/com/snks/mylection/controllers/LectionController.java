package com.snks.mylection.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.snks.mylection.model.Lection;
import com.snks.mylection.service.LectionService;
import com.snks.mylection.service.UserService;

@Controller
public class LectionController {
	@Autowired
	private UserService userServise;
	@Autowired
	private LectionService lectionService;
	
	@RequestMapping("/addlection")
    public String login(Model model,Principal principal) {
	   return "lection_blank";
    }
	
	
	@RequestMapping(value="/addlection/save",method=RequestMethod.POST)
    public String addLection(@RequestBody String bodyContent) {
		System.out.println(bodyContent);
		return "lection_blank";
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
