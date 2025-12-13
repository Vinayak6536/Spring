package com.xworkz.wired.example48;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TabletRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Tablet tablet = context.getBean(Tablet.class);

        tablet.setBrand("Samsung");
        tablet.setModel("Galaxy Tab");
        tablet.setPrice(65000);
        tablet.setStylus(new Stylus("S-Pen", true, 10));

        System.out.println(tablet);

        System.out.println("main ended");
    }
}
