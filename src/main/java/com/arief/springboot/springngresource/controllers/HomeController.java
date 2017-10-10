package com.arief.springboot.springngresource.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {


    @RequestMapping
    public String homeView(){
        return "Hello";
    }
}
