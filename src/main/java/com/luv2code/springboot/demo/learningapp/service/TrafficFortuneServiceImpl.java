package com.luv2code.springboot.demo.learningapp.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {

    @Override
    public String getFortune(boolean trip) {

        if (trip) throw new RuntimeException("Oh not again...");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "Except heavy traffic.";
    }
}
