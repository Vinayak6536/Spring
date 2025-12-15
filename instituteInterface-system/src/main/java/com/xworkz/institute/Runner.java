package com.xworkz.institute;

import com.xworkz.institute.config.InstituteConfiguration;
import com.xworkz.institute.institute.Institute;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(InstituteConfiguration.class);

        Institute institute=applicationContext.getBean(Institute.class);
        institute.setId(1);
        institute.setName("Vinayak");
        institute.getAddTrainee();
        System.out.println(institute);

        System.out.println("main ended");
    }
}
