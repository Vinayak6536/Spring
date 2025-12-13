package com.xworkz.wired.example44;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class WatchRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Watch watch = context.getBean(Watch.class);

        watch.setBrand("Fossil");
        watch.setModel("Chronograph");
        watch.setPrice(15000);
        watch.setStrap(new Strap("Leather", "Brown", 42));

        System.out.println(watch);

        System.out.println("main ended");
    }
}
