package com.kaanakcay.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    //showing inital form
//    @RequestMapping("/showForm") //support any http request asagida bunu get e ceviricem
//    public String showForm(){
//        return "helloworld-form";
//    }

    @GetMapping("/showForm") //sadece get request cunku direkt sayfa bile olsa bi get ile sayfayi cagiriyoruz.
    public String showForm(){
        return "helloworld-form";
    }

    // process the html form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld-form-submit";
    }

    //reading form data and adding to model (1. yol)
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){
        String theName = request.getParameter("studentName");
        theName = theName.toUpperCase();
        String result = "Yo! " + theName;

        model.addAttribute("message", result);
        return "helloworld-form-submit";
    }

    // 2.yol
    @PostMapping("/processFormVersionThree") //burada RequestMapping ve GetMapping de kullanabiliriz post olmasina gerek yok ama post yaparsan daha url e eklenmez body de gonderilir, bunu ogeyi denetle payload kismindan gorebilirsin. ve hem url hem de body icin requestParams kullanabilirsin
    public String letsShoutDude2(@RequestParam("studentName") String theName, Model model){
        theName = theName.toUpperCase();
        String result = "Yo! " + theName;

        model.addAttribute("message", result);
        return "helloworld-form-submit";
    }
}
