package com.xworkz.wired.example2;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Mobile mobile = context.getBean(Mobile.class);
        mobile.setBrand("Samsung");
        mobile.setModel("Galaxy S23");
        mobile.setPrice(70000);
        mobile.setCamera(new Camera(108, "Wide", true));

        System.out.println(mobile);


        System.out.println("main ended");
    }
}
