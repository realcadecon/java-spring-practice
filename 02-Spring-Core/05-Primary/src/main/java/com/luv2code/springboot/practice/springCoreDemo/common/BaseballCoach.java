package com.luv2code.springboot.practice.springCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Batting practice for 15 mins, then ground ball practice for 15 mins.";
    }
}
