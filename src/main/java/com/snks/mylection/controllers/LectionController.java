package com.snks.mylection.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LectionController {
	
	@RequestMapping("/addlection")
    public String login() {
	   return "lection_blank";
    }

}
