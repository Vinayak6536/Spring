package com.xworkz.wired.example58;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CourtRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Court court = context.getBean(Court.class);

        court.setName("High Court");
        court.setCity("Bangalore");
        court.setCasesPerDay(120);
        court.setJudge(new Judge("Justice Rao", 22, "Civil"));

        System.out.println(court);

        System.out.println("main ended");
    }
}
