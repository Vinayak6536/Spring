package com.xworkz.wired.example42;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BikesRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Bikes bike = context.getBean(Bikes.class);

        bike.setBrand("Yamaha");
        bike.setModel("R15");
        bike.setPrice(180000);
        bike.setEngine(new BikeEngine(155, "Petrol", true));

        System.out.println(bike);

        System.out.println("main ended");
    }
}
