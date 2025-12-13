package com.xworkz.wired.example32;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MallRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Mall mall = context.getBean(Mall.class);

        mall.setName("Orion Mall");
        mall.setCity("Bangalore");
        mall.setShops(150);
        mall.setShop(new Shop("Reliance", "Clothing", 2));

        System.out.println(mall);

        System.out.println("main ended");
    }
}
