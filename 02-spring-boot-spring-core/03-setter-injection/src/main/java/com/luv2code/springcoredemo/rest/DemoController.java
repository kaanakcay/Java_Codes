package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    @Autowired
    public void setCoach(Coach theCoach){ //daha onceki ornekte constructor uzerinden coach inject etmistik simdi bi setter method uzerinden yapiyoruz. Buraya setCoach yerine herhangi bisey de yapaiblirsin.
        myCoach = theCoach;
    }

   @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
       return myCoach.getDailyWorkout();
   }
}
