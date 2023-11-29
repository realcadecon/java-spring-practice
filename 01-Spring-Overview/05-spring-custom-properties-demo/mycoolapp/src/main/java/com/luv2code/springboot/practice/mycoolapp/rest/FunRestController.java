package com.luv2code.springboot.practice.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FunRestController {

    @Value("${workout.strength}")
    private String[] strengthWorkouts;

    @Value("${workout.cardio}")
    private String[] cardioWorkouts;

    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        int cardio = 0;
        int strength = 0;
        String workoutOfTheDay = String.format("Today's Workout: Strength = %s | Cardio = %s", strengthWorkouts[strength], cardioWorkouts[cardio]);
        return workoutOfTheDay;
    }
}
