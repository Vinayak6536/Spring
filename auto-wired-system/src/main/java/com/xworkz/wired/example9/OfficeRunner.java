package com.xworkz.wired.example9;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OfficeRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Office office = context.getBean(Office.class);
        office.setName("Tech Corp");
        office.setEmployees(100);
        office.setLocation("Mumbai");
        office.setPrinter(new Printer("Laser", 30, true));

        System.out.println(office);

        System.out.println("main ended");
    }
}
