package com.xworkz.wired.example49;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RefrigeratorRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Refrigerator fridge = context.getBean(Refrigerator.class);

        fridge.setBrand("Whirlpool");
        fridge.setLitres(340);
        fridge.setPrice(38000);
        fridge.setFreezer(new Freezer(90, true, -18));

        System.out.println(fridge);

        System.out.println("main ended");
    }
}
