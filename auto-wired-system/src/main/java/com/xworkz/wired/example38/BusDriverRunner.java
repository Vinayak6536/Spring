package com.xworkz.wired.example38;

import com.xworkz.wired.config.WireConfiguration;
import com.xworkz.wired.example15.Bus;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BusDriverRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        BusDriver bus = context.getBean(BusDriver.class);

        bus.setNumber("KA-01-1234");
        bus.setRoute("Majestic–BTM");
        bus.setSeats(45);
        bus.setDriver(new Driver("Mahesh", 98765, 12));

        System.out.println(bus);

        System.out.println("main ended");
    }
}
