package com.luv2code.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach; //demo controller need this so this is a dependency and we need to inject that.

   @Autowired //optional because there is only one constructor
    public DemoController(Coach theCoach){
       this.myCoach = theCoach;
   }

   @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
       return myCoach.getDailyWorkout();
   }
}
