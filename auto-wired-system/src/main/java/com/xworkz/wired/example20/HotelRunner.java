package com.xworkz.wired.example20;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HotelRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Hotel hotel = context.getBean(Hotel.class);
        hotel.setName("Grand Palace");
        hotel.setLocation("Goa");
        hotel.setStars(5);
        hotel.setHotelRoom(new HotelRoom(101, "Deluxe", 12000));

        System.out.println(hotel);

        System.out.println("main ended");
    }
}
