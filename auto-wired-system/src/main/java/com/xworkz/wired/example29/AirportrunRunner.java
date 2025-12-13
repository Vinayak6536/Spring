package com.xworkz.wired.example29;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AirportrunRunner {
    public static void main(String[] args) {
        System.out.println("main started");
        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        AirportRun airport = context.getBean(AirportRun.class);

        airport.setName("IGI Airport");
        airport.setCity("Delhi");
        airport.setTerminals(3);
        airport.setRunway(new Runway(4500, "Concrete", true));

        System.out.println(airport);
        System.out.println("main ended");
    }
}
