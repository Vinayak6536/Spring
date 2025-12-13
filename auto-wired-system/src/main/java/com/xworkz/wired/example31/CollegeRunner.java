package com.xworkz.wired.example31;

import com.xworkz.wired.config.WireConfiguration;
import com.xworkz.wired.example11.School;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CollegeRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        College school = context.getBean(College.class);

        school.setName("Green Valley School");
        school.setCity("Pune");
        school.setStudents(1200);
        school.setPrincipal(new Principal("Suresh", 20, "M.Ed"));

        System.out.println(school);

        System.out.println("main ended");
    }
}
