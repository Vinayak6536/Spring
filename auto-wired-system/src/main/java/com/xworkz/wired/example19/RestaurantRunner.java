package com.xworkz.wired.example19;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RestaurantRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Restaurant restaurant = context.getBean(Restaurant.class);
        restaurant.setName("Spicy Treat");
        restaurant.setLocation("Delhi");
        restaurant.setTables(20);
        restaurant.setChef(new Chef("Chef Raj", "Indian", 10));

        System.out.println(restaurant);

        System.out.println("main ended");
    }
}
