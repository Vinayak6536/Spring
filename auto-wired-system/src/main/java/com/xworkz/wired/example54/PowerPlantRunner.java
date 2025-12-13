package com.xworkz.wired.example54;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PowerPlantRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        PowerPlant plant = context.getBean(PowerPlant.class);

        plant.setName("NTPC");
        plant.setLocation("Korba");
        plant.setUnits(6);
        plant.setTurbine(new Turbine(500, "Steam", true));

        System.out.println(plant);

        System.out.println("main ended");
    }

}
