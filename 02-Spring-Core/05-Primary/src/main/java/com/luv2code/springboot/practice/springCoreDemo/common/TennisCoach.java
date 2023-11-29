package com.luv2code.springboot.practice.springCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice serves for 15 mins.";
    }
}
