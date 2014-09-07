package com.snks.mylection.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.snks.mylection.model.Lection;
import com.snks.mylection.service.LectionService;

@Controller
@RequestMapping("/")
public class HelloController {
	
	@Autowired
	private LectionService lectionService;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
		List<Lection> lections = lectionService.findLast();
		model.addAttribute("lections",lections);
        return "welcomePage";

    }
    
}