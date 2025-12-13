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
        airport.setTerminal(new Terminal(1,"Baba"));
      //  airport.getTerminal();
        System.out.println(airport);

        Airport airport1=applicationContext.getBean(Airport.class);
        airport1.setAirportId(3);
        airport1.setTerminal(new Terminal(2,"Babi"));
       // airport1.getTerminal();
        System.out.println(airport1);

        Airport airport2=applicationContext.getBean(Airport.class);
        airport2.setAirportId(5);
        airport2.setTerminal(new Terminal(3,"Baby"));
       // airport2.getTerminal();
        System.out.println(airport2);

        System.out.println("main ended");
    }
}
