package com.xworkz.wired.example55;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MuseumRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Museum museum = context.getBean(Museum.class);

        museum.setName("National Museum");
        museum.setCity("Delhi");
        museum.setVisitorsPerDay(3000);
        museum.setArtifact(new Artifact("Ancient Coin", "Maurya", "Gold"));

        System.out.println(museum);

        System.out.println("main ended");
    }
}
