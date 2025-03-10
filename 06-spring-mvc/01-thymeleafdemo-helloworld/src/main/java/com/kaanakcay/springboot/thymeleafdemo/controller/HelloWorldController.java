package com.kaanakcay.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    //showing inital form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    // process the html form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld-form-submit";
    }

    //reading form data and adding to model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){
        String theName = request.getParameter("studentName");
        theName = theName.toUpperCase();
        String result = "Yo! " + theName;

        model.addAttribute("message", result);
        return "helloworld-form-submit";
    }
}
