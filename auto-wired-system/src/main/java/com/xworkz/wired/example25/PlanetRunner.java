package com.xworkz.wired.example25;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PlanetRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Planet planet = context.getBean(Planet.class);

        planet.setName("Earth");
        planet.setMass(5.97e24);
        planet.setNoOfMoons(1);
        planet.setMoon(new Moon("Moon", 1737.1, true));

        System.out.println(planet);

        System.out.println("main ended");
    }
}
