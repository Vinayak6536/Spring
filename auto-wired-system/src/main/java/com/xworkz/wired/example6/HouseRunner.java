package com.xworkz.wired.example6;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HouseRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        House house = context.getBean(House.class);
        house.setOwner("Bharat");
        house.setRooms(5);
        house.setCity("New York");
        house.setDoor(new Door("Wood", 210, true));

        System.out.println(house);

        System.out.println("main ended");
    }
}
