package com.xworkz.wired.example51;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TheatreRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Theatre theatre = context.getBean(Theatre.class);

        theatre.setName("INOX");
        theatre.setCity("Pune");
        theatre.setShows(10);
        theatre.setScreen(new Screen1(2, "4DX", 250));

        System.out.println(theatre);

        System.out.println("main ended");
    }
}
