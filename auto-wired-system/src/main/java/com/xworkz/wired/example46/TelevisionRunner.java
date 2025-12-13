package com.xworkz.wired.example46;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TelevisionRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Television tv = context.getBean(Television.class);

        tv.setBrand("Sony");
        tv.setSize(55);
        tv.setSmartTv(true);
        tv.setRemote(new Remote("Bluetooth", 40, true));

        System.out.println(tv);

        System.out.println("main ended");
    }
}
