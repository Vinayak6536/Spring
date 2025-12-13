package com.xworkz.wired.example17;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClassRoomRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        ClassRoom classroom = context.getBean(ClassRoom.class);
        classroom.setName("Room A1");
        classroom.setCapacity(50);
        classroom.setFloor(2);
        classroom.setProjector(new Projector("Epson", 3000, true));

        System.out.println(classroom);

        System.out.println("main ended");
    }
}
