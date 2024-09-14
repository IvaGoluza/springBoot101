package com.luv2code.springboot.demo.learningapp.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Baseball Daily Workout";
    }
}
