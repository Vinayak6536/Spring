package com.xworkz.wired.example36;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RailwayStationRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        RailwayStation station = context.getBean(RailwayStation.class);

        station.setName("Howrah Junction");
        station.setCity("Kolkata");
        station.setTrains(250);
        station.setPlatform(new Platform(1, 1200, true));

        System.out.println(station);

        System.out.println("main ended");
    }
}
