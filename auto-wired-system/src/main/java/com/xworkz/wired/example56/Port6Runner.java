package com.xworkz.wired.example56;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Port6Runner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Port port = context.getBean(Port.class);

        port.setName("Mumbai Port");
        port.setCity("Mumbai");
        port.setDocks(15);
        port.setShip(new Shipment("INS Vikrant", 4500, "Cargo"));

        System.out.println(port);

        System.out.println("main ended");
    }
}
