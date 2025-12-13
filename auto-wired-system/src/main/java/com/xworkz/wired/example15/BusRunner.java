package com.xworkz.wired.example15;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BusRunner {
    public static void main(String[] args) {
        System.out.println("main started");


        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Bus bus = context.getBean(Bus.class);
        bus.setRoute("Mumbai-Pune");
        bus.setCapacity(40);
        bus.setFare(800);
        bus.setSeat(new Seat("Leather", 1, true));

        System.out.println(bus);

        System.out.println("main ended");
    }
}
