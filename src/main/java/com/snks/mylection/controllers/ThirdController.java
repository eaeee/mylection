package com.snks.mylection.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("third")
public class ThirdController {
    @RequestMapping(method = RequestMethod.GET)
    public String printSecond(ModelMap model) {
        return "index";

    }

}
