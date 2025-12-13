package com.xworkz.wired.example24;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ShipRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Ship ship = context.getBean(Ship.class);

        ship.setName("Queen Mary");
        ship.setTonnage(150000);
        ship.setType("Cruise");
        ship.setCaptain(new Captain("Captain Smith", 25, "British"));

        System.out.println(ship);

        System.out.println("main ended");
    }
}
