package com.luv2code.springboot.practice.springCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }
    public String getDailyWorkout(){
        return "Practice fast bowling for 15 mins!!!";
    }
}
