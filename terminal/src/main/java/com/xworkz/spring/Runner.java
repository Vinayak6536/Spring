package com.xworkz.spring;

import com.xworkz.spring.airport.Airport;
import com.xworkz.spring.configure.AirportConfiguration;
import com.xworkz.spring.terminal.Terminal;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext applicationContext= new AnnotationConfigApplicationContext(AirportConfiguration.class);

        Airport airport=applicationContext.getBean(Airport.class);
        airport.setAirportId(2);
        System.out.println(airport);

        airport.setTerminal(new Terminal(1,"Baba"));
        airport.getTerminal();
        System.out.println(airport);
        System.out.println("main ended");
    }
}
