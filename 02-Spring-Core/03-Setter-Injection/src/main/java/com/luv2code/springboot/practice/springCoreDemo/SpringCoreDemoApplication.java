package com.luv2code.springboot.practice.springCoreDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
@SpringBootApplication(scanBasePackages = {
				"com.luv2code.springboot.practice.springCoreDemo",
				"com.luv2code.springboot.practice.util" })
 */

@SpringBootApplication
public class SpringCoreDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreDemoApplication.class, args);
	}

}
