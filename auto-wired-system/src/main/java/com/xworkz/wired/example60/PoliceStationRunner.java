package com.xworkz.wired.example60;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PoliceStationRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        PoliceStationOne station = context.getBean(PoliceStationOne.class);

        station.setName("City Police");
        station.setCity("Mangalore");
        station.setStaff(120);
        station.setInspector(new Inspector("Kumar", 556, 14));

        System.out.println(station);

        System.out.println("main ended");
    }
}
