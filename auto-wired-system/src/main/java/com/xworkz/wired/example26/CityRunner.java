package com.xworkz.wired.example26;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CityRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        City city = context.getBean(City.class);

        city.setName("New York");
        city.setPopulation(8419000);
        city.setArea(783.8);
        city.setMayor(new Mayor("John Doe", 55, 4));

        System.out.println(city);

        System.out.println("main ended");
    }
}
