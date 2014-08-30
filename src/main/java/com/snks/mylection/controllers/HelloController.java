package com.snks.mylection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.snks.mylection.service.LectionService;

@Controller
@RequestMapping("/")
public class HelloController {
	
	@Autowired
	private LectionService lectionService;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Spring 3 MVC - Hello World!");
        lectionService.addDefaultLection();
        return "welcomePage";

    }
    
}