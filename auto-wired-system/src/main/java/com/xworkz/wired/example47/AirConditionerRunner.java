package com.xworkz.wired.example47;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AirConditionerRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        AirConditioner ac = context.getBean(AirConditioner.class);

        ac.setBrand("LG");
        ac.setTon(2);
        ac.setPrice(48000);
        ac.setCompressor(new Compressor("LG", 18000, true));

        System.out.println(ac);

        System.out.println("main ended");
    }
}
