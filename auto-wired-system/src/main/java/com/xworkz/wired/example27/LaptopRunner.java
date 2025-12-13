package com.xworkz.wired.example27;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LaptopRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Laptop laptop = context.getBean(Laptop.class);

        laptop.setBrand("Dell");
        laptop.setModel("Inspiron");
        laptop.setPrice(80000);
        laptop.setRam(new RAM(16, "DDR4", 3200));

        System.out.println(laptop);

        System.out.println("main ended");
    }
}
