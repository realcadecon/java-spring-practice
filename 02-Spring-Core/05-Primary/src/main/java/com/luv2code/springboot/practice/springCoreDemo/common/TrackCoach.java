package com.luv2code.springboot.practice.springCoreDemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class TrackCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Run 10 100m sprints.";
    }
}
