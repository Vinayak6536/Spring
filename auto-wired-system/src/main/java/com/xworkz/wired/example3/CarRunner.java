package com.xworkz.wired.example3;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CarRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Car car = context.getBean(Car.class);
        car.setBrand("Toyota");
        car.setYear(2024);
        car.setPrice(1200000);
        car.setEngine(new Engine(150, "Petrol", 4));

        System.out.println(car);

        System.out.println("main ended");
    }
}
