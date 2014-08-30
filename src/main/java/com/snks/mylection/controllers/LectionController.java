package com.snks.mylection.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LectionController {
	@RequestMapping("/lection/{id}")
	public String getLection(Model model,@PathVariable int id) {
		
		model.addAttribute("id",id);
		return "lectionTest";
		
	}

}
