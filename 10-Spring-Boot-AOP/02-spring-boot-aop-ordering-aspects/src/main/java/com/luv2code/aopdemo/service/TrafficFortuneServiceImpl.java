package com.luv2code.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {

    @Override
    public String getFortune() {
        //simulate delay
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //return fortune
        return "There will be heavy traffic today!!!";
    }

    @Override
    public String getFortune(boolean tripwire) {
        //simulate delay
        try {
            if(tripwire) {
                throw new RuntimeException("trip wire tripped - panic");
            }
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "There will be heavy traffic today!!!";
    }
}
