package com.xworkz.wired.example33;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UniversityRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        University university = context.getBean(University.class);

        university.setName("Delhi University");
        university.setCity("Delhi");
        university.setColleges(90);
        university.setProfessor(new Professor("Dr. Sharma", "Physics", 25));

        System.out.println(university);

        System.out.println("main ended");
    }
}
