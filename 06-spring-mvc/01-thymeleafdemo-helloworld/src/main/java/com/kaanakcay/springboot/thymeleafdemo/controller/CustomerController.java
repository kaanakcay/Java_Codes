package com.kaanakcay.springboot.thymeleafdemo.controller;


import com.kaanakcay.springboot.thymeleafdemo.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    //whitespace engellemek icin gelen tum requestleri elden geciren InitBinder
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

    }


    @GetMapping("/")
    public String showForm(Model theModel){
        theModel.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer,BindingResult theBindingResult){ //binding result hold the result of the validation


        if(theBindingResult.hasErrors()){
            return "customer-form";
        }else{
            return "customer-confirmation";
        }


    }
}
