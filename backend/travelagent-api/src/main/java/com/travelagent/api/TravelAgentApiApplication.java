package com.travelagent.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TravelAgentApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(TravelAgentApiApplication.class, args);
    }
}
