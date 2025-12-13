package com.xworkz.wired.example8;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BikeRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Bike bike = context.getBean(Bike.class);
        bike.setBrand("Yamaha");
        bike.setModel("R15");
        bike.setPrice(150000);
        bike.setFuelTank(new FuelTank(12, "Petrol", true));

        System.out.println(bike);

        System.out.println("main ended");
    }
}
