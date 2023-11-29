package com.luv2code.springboot.practice.springCoreDemo.config;

import com.luv2code.springboot.practice.springCoreDemo.common.Coach;
import com.luv2code.springboot.practice.springCoreDemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
