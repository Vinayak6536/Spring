package com.xworkz.wired.example22;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TrainRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Train train = context.getBean(Train.class);

        train.setName("Shatabdi Express");
        train.setRoute("Delhi-Agra");
        train.setSpeed(120);
        train.setCoach(new Coach("Sleeper", 72, false));

        System.out.println(train);

        System.out.println("main ended");
    }
}
