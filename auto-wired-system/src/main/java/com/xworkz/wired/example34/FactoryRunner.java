package com.xworkz.wired.example34;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FactoryRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Factory factory = context.getBean(Factory.class);

        factory.setName("Tata Steel");
        factory.setLocation("Jamshedpur");
        factory.setWorkers(10000);
        factory.setMachine(new Machine("Rolling", 500, true));

        System.out.println(factory);

        System.out.println("main ended");
    }
}
