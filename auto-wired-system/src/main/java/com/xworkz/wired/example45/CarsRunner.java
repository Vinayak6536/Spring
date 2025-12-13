package com.xworkz.wired.example45;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CarsRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Cars car = context.getBean(Cars.class);

        car.setBrand("Honda");
        car.setModel("City");
        car.setPrice(1200000);
        car.setGearBox(new GearBox("Manual", 6, false));

        System.out.println(car);

        System.out.println("main ended");
    }
}
