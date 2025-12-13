package com.xworkz.wired.example57;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FarmRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Farm farm = context.getBean(Farm.class);

        farm.setOwner("Ravi");
        farm.setLocation("Mandya");
        farm.setAcres(25);
        farm.setTractor(new Tractor("Mahindra", 55, true));

        System.out.println(farm);

        System.out.println("main ended");
    }
}
