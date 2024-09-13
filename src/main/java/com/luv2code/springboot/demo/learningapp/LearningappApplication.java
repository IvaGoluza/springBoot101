package com.luv2code.springboot.demo.learningapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.luv2code.util", "com.luv2code.springboot.demo.learningapp"})
public class LearningappApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningappApplication.class, args);
	}

}
