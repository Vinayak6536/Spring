package com.xworkz.wired.example35;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CinemaRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Cinema cinema = context.getBean(Cinema.class);

        cinema.setName("PVR");
        cinema.setCity("Hyderabad");
        cinema.setShows(12);
        cinema.setScreen(new Screen(3, "IMAX", 300));

        System.out.println(cinema);

        System.out.println("main ended");
    }
}
