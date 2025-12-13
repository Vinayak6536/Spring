package com.xworkz.wired.example21;

import com.xworkz.wired.config.WireConfiguration;
import com.xworkz.wired.example15.Seat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StadiumRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Stadium stadium = context.getBean(Stadium.class);
        stadium.setName("Wankhede Stadium");
        stadium.setCapacity(33000);
        stadium.setCity("Mumbai");
        stadium.setSeats(new Seats(101, "A", true));

        System.out.println(stadium);

        System.out.println("main ended");
    }
}
