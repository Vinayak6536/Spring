package com.xworkz.wired.example59;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RadioStationRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        RadioStation station = context.getBean(RadioStation.class);

        station.setName("Radio Mirchi");
        station.setFrequency(98.3);
        station.setCity("Bangalore");
        station.setRj(new RJ("Neha", "Morning Masala", 6));

        System.out.println(station);

        System.out.println("main ended");
    }
}
