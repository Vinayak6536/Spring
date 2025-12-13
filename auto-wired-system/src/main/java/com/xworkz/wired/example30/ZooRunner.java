package com.xworkz.wired.example30;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ZooRunner {
    public static void main(String[] args) {
        System.out.println("main started");
        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Zoo zoo = context.getBean(Zoo.class);

        zoo.setName("Mysore Zoo");
        zoo.setCity("Mysore");
        zoo.setAnimals(350);
        zoo.setKeeper(new Keeper("Ramesh", 10, "Morning"));

        System.out.println(zoo);

        System.out.println("main ended");
    }
}
