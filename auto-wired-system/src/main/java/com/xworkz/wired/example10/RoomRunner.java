package com.xworkz.wired.example10;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RoomRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Room room = context.getBean(Room.class);
        room.setName("Living Room");
        room.setArea(250);
        room.setFloor(1);
        room.setFan(new Fan(3, "Ceiling", true));

        System.out.println(room);

        System.out.println("main ended");
    }
}
