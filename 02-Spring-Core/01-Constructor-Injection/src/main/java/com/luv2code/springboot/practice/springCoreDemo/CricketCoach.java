package com.luv2code.springboot.practice.springCoreDemo;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public String getDailyWorkout(){
        return "Practice fast bowling for 15 mins!!!";
    }
}
