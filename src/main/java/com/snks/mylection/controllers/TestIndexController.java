package com.snks.mylection.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestIndexController {
	   @RequestMapping(value = {"/index1"})
	    public String login() {
		   return "index1";
	    }
}
