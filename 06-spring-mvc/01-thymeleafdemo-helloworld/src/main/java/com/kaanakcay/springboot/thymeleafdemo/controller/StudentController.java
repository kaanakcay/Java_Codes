package com.kaanakcay.springboot.thymeleafdemo.controller;


import com.kaanakcay.springboot.thymeleafdemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){
        theModel.addAttribute("student", new Student());
        return "student-form";

    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student")Student theStudent){

        System.out.println("theStudent: " + theStudent.getFirstName() + ' ' + theStudent.getLastName());
        return "student-confirmation";
    }
}
