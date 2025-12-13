package com.xworkz.wired.example50;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GYMRunner {

    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        GYM gym = context.getBean(GYM.class);

        gym.setName("Gold's Gym");
        gym.setArea("JP Nagar");
        gym.setEquipments(120);
        gym.setTrainer(new Trainer("Vikram", "ACE", 8));

        System.out.println(gym);

        System.out.println("main ended");
    }
}
