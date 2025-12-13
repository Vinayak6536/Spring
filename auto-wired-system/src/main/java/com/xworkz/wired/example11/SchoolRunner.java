package com.xworkz.wired.example11;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SchoolRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        School school = context.getBean(School.class);
        school.setName("Greenwood High");
        school.setCity("Bangalore");
        school.setStudents(800);
        school.setTeacher(new Teacher("Mr. John", "Math", 12));

        System.out.println(school);

        System.out.println("main ended");
    }
}
