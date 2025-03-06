package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

   @Autowired //optional because there is only one constructor
    public DemoController(Coach theCoach){
       this.myCoach = theCoach;
   }

   @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
       return myCoach.getDailyWorkout();
   }
}
