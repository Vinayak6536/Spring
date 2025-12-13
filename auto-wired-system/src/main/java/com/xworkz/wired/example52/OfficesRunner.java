package com.xworkz.wired.example52;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OfficesRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Offices office = context.getBean(Offices.class);

        office.setName("Tech Park");
        office.setLocation("Electronic City");
        office.setEmployees(5000);
        office.setCabin(new Cabin(205, "Manager", true));

        System.out.println(office);

        System.out.println("main ended");
    }
}
