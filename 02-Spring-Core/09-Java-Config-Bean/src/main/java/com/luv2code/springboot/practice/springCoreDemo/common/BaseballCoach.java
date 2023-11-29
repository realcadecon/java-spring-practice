package com.luv2code.springboot.practice.springCoreDemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
    public BaseballCoach() {
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }

    public String getDailyWorkout() {
        return "Batting practice for 15 mins, then ground ball practice for 15 mins.";
    }
}
