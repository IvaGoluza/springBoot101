package com.luv2code.springboot.demo.learningapp.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BaseballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Baseball Daily Workout";
    }
}
