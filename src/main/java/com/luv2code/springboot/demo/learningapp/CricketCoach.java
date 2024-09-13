package com.luv2code.springboot.demo.learningapp;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Practice for Cricket Coach";
    }
}
