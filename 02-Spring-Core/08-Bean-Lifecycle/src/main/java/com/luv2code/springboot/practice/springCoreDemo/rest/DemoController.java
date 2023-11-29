package com.luv2code.springboot.practice.springCoreDemo.rest;

import com.luv2code.springboot.practice.springCoreDemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach headCoach;

    @Autowired
    public DemoController(@Qualifier("baseballCoach") Coach hCoach){
        System.out.println("In Constructor: " + getClass().getSimpleName());
        headCoach = hCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return headCoach.getDailyWorkout();
    }
}

