package com.luv2code.springboot.demo.learningapp.rest;

import com.luv2code.springboot.demo.learningapp.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach coach;  // private field - dependency injection

    @Autowired  // add qualifier if you have multiple classes implementing Coach interface
    public DemoController(@Qualifier("cricketCoach") Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }

}
