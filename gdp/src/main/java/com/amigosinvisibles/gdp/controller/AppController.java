package com.amigosinvisibles.gdp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AppController {

    @GetMapping
    public String principal(){
        return "app/home";
    }

    @GetMapping("/principal")
    public String home(){
        return "app/principal";
    }

    @GetMapping(value="/error", produces="application/json; charset=UTF-8")
    public String error(){
        return "error";
    }

}
