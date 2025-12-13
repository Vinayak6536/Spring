package com.xworkz.wired.example5;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudentRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Student student = context.getBean(Student.class);
        student.setName("Darshan");
        student.setRollNo(101);
        student.setGrade("A");
        student.setPen(new Pen("Blue", "Ballpoint", 10));

        System.out.println(student);

        System.out.println("main ended");
    }
}
