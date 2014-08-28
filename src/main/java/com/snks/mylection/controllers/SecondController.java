package com.snks.mylection.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("second")
public class SecondController {
    @RequestMapping(method = RequestMethod.GET)
    public String printSecond(ModelMap model) {

        model.addAttribute("second", "Жесть!!!");
        return "second";

    }

}
