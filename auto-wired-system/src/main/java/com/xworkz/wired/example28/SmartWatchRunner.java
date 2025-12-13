package com.xworkz.wired.example28;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SmartWatchRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        SmartWatch watch = context.getBean(SmartWatch.class);

        watch.setBrand("Apple");
        watch.setModel("Series 9");
        watch.setPrice(45000);
        watch.setSensor(new Sensor("HeartRate", true, 5));

        System.out.println(watch);

        System.out.println("main ended");
    }
}
